---
title: Understanding Coroutines
description: Understanding Coroutines
date: 2019-07-29
---

## Understanding Coroutines

Conceptually, coroutines are like threads, executing units of work concurrently. But unlike threads, coroutines aren’t necessarily bound to any particular thread.

A coroutine can start executing in one thread, suspend execution, and resume on a different thread.

Coroutines are managed at the user space level by the Kotlin Runtime. That means there is no time slice allocated to a coroutine to perform a unit of work. That also means there’s no scheduler overhead. Instead, coroutines perform cooperative multitasking. When one coroutine hits a suspension point, the Kotlin Runtime will find another coroutine to resume. You can think of this like having multiple coroutines multiplexed on to a single thread.

Coroutines have a small memory footprint — a few dozen bytes. That gives you a very high level of concurrency with very little overhead.

Both Coroutines and RxJava offer switching between the Main Thread, Computation, and IO. Coroutines however have the Unconfined thread option which can switch threads in the middle of a coroutine, while RxJava has a few more options including Trampoline, Single, and NewThread.

```
suspend fun loadUser() {
    withContext(Dispatchers.IO) {
        /* Network Call */
        val user = api.fetchUser()
    }
}
```

So, should you switch from RxJava to Coroutine or not?
If your app…

  -  is already running with RxJava, don’t bother switching
  -  runs network calls once or twice per activity creation, use Coroutines
  -  needs to be simple and easily-read by less experienced coders, Coroutines
  -  runs any sort of real-time feature, use RxJava
  -  needs high levels of data manipulation between fetching and emitting, RxJava
  -  needs a combination of the use cases above, well combine the two!



### Resources
https://proandroiddev.com/kotlin-coroutines-channels-csp-android-db441400965f