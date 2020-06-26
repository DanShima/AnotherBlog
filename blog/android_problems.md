---
title: Android miscellaneous problems
description: Various Android problems I encountered in my first year
date: 2019-07-10
tags: ['Android']
---

### Various Android problems I encountered in my first year

No matter how many tutorials you watch or how many lines of code you read, nothing gets you to learn faster than just build an app and encounter all kinds of problems while doing so. After one year, I have had my fair share of pulling hair and stalking StackOverflow for solutions. Here are some problems I remember and hopefully I'll keep this post updated with new problems!

* **Set focus on the edit input field with editText.requestFocus() if android:focusable = true in xml doesn't work.**

* **Recyclerview adapter position wasn't updated accurately.**
>```
adapter.setHasStableIds(true)
> ```
    With StableIds enabled, the Adapter knows which Items to invalidate and which to keep, thus preventing flickering.
    after calling setHasStableIds(true) on your adapter, override getItemId(int position) to return a unique Id that would represent each Data Item, simply return the HashCode if you cannot think of anything better.

> ```
override fun getItemId(position: Int): Long {    return kvItems[position].hashCode().toLong()}
> ```
    Then in onBindViewHolder you can set UI changes dynamically, like giving round corners to the last item within a group.

> ```
if (position + 1 >= itemCount) {
    if (position == kvItems.lastIndex) {
        layout.background = roundFooter
    } else {
        if (getItemViewType(position + 1) == KvListItem.typeDate) {
            layout.background = roundFooter
            } else {
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.kivraGrayLightest))
            }
    }
}
> ```

* **Api request that succeeded but the view was not refreshed. Turns out the request needed a subscribe() block.**
> ```
fun clear(): Disposable {
    return Completable.fromCallable {
        contentItemDao.deleteTrashedContentItems()
        }
        .toNetworkCompletable()
        .subscribe({ Timber.d("success") }, { Timber.d("fail") })
        }}
> ```
* **Mocking network requests for testing: MockWebServer should be used for testing** [article] (https://android.jlelse.eu/unit-test-api-calls-with-mockwebserver-d4fab11de847)
![alt text](https://s3.amazonaws.com/8silo.penzu.com/photos/5209199/big/Screen_Shot_2019-04-11_at_09.25.22.png?1554967551)

* **Set value of a liveData on the mainthread using postValue("value")**
* **Read a file from raw assets**
> ```
val file = activity.resources.openRawResource(R.raw.json2).bufferedReader().use { it.readText() }
// use a local pdf file
val file = targetContext.resources.openRawResource(R.raw.testpdf).buffered()
val result = Buffer()
result.writeAll(Okio.source(file))
> ```
* **Using idlingResource**
> ```
//In activity:
val idlingResource = CountingIdlingResource("uniqueName")
idlingResource.increment() before the process, and decrement when it's done.
In Test, call Espresso.registerIdlingResources(activityRule.activity.idlingresource() beefore testing "onView(withID....")
> ```
* **Make FAB move when snackbar appears: fab and snack in a CoordinatorLayout app:layout_dodgeInsetEdges="bottom".**

* **Save info in sharedPreferences**
>```
private fun saveVersionCode() {
    getSharedPreferences(SHARED_PREFERENCE_ID, Context.MODE_PRIVATE).edit(true) {
        putInt(VERSION_CODE, BuildConfig.VERSION_CODE)
        }
}
>```

* **Force Gradle to use a version for a dependency used by another dependency**
>```
    //in build.gradle under dependencies, add:
    configurations.all {
        resolutionStrategy {
            force 'com.squareup:javapoet:1.13.0
        }
    }
>```