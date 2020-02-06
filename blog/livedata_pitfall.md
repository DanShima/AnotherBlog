---
title: SetValue vs PostValue - which one should you use for liveData
description: how to update observable value in android
date: 2020-02-06
tags: ['Android', 'lifeCycle']
---

This week I encountered a peculiar bug at work where the data from network, wrapped in liveData, is fetched only once every two times even though forceFetch boolean is specifically set to true. After investigating for an entire day and logging every steps, I accidentally stumbled upon the documentation on setValue and postValue for liveData.

Both will update the liveData value expected when running from the main thread. PostValue is thread safe and can be used in another thread. see **official documentation** [article] (https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData.html#postValue(T))

example:
> ```
    val fetchData = MutableLiveData<Boolean>()
    //setValue
    fetchData.value = true
    fetchData.value = false
    //postValue
    fetchData.postValue(true)
    fetchData.postValue(false)
> ```

Both code run twice when observed, but for postValue, only the second call triggers the observer! HUH?
* **This is why:**
Value is being set immediately in a synchronized code block for thread safety, but the observers notification is scheduled to execute on main thread via the event loop (with handler). Value changes to true and then false but scheduling code occurs only once. postTask in the implementation determines whether a runnable needs to be scheduled for notifying observers.

> ```
protected void postValue(T value) {
   boolean postTask;
   synchronized (mDataLock) {
       postTask = mPendingData == NOT_SET;
       mPendingData = value;
   }
   if (!postTask) {
       return;
   }
   ArchTaskExecutor.getInstance().postToMainThread(mPostValueRunnable);
}
> ```
* **When to use which**
My bug was likely because I call postValue for several data sets, and set forceFetch to false just one step later in the code, so only the last value is dispatched.
Use postValue: UI progress update
Don't use postValue: getting notified for each change
I feel like using setValue is safer in general unless the code you run is definitely not done on the main thread. Or when you only care about the last value in a series of asking for the data in your application.