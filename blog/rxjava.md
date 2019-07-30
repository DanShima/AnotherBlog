---
title: Intro to RxJava
description: Intro to RxJava
date: 2019-07-30
---

## Intro to RxJava

With an observer, you can receive a stream of data emitted by an observable.

### Different types of observable

- **Single**: A flow of exactly 1 item or an error.

- **Maybe** : A flow with no items, exactly one item or an error. Can use the defaultIfEmpty method to always emit a default value where zero values would be emitted.

- **Completable** : A flow without items but only a completion or error signal. This type may also emit an error. This is basically an “event” that indicates something happened or finished. It could be used to indicate state change, such as when a fragment is destroyed (which can happen only once).


- **Flowable** : An observable that can handle back pressure
```
    val flow = Observable.range(1, 100000).toFlowable(BackpressureStrategy.DROP)
    val flowableObserver = flow.subscribe {data ->
    Log.d(LOG_TAG, "Received $data")
    }
```

### Error-handling

- **doOnError** : Simply perform an action if an error occurs
```
val observer = myObservable
    .doOnError { Log.e(LOG_TAG, "ErrorOccurred") }
    .subscribe()
```

- **onErrorReturnItem** : Return a default item if an error occurs
```
val observer = myObservable
    .onErrorReturnItem(0)
    .subscribe()
    }
```
- **onErrorReturn**: Just like onErrorReturnItem, but takes in a function that returns the desired data type (for a dynamic default value)
```
val observer = myObservable
        .onErrorReturn{ throwable -> throwable.message}
        .subscribe()
```

- **onErrorResumeNext** : Returns a default sequence if an error occurs. Can also take a function for dynamic data.
```
val observer = myObservable
        .onErrorResumeNext(Observable.just(2, 4, 6))
        .subscribe()
```

- **retry** : Attempt resubscribing to the observable if an error occurs. You can pass in a maximum number of tries, or leave it blank for it to retry infinitely. You can also pass in a boolean predicate to achieve a ‘retry-on-condition’ scenario.

```
val observer = myObservable
        .retry{ integer, throwable -> integer > 0 }
        .subscribe()
```

### Operators
Too many to cover but here are some commonly used ones.
- **from**: Creates an observable from any iterable.
- **defer** : Creates a new observable instance each time an observer subscribes. whereas _create_ operator emits [1] for below code, defer emits  [1, 1, 1]
```
var a = 0
val observable = Observable.defer {
    Observable.create<Int> { emitter ->
        a++
        emitter.onNext(a)
    }
}
```
- **just**: pass in up to 10 objects of any type and they will be emitted.
- **range**: pass in a range of values and they will be emitted.
- **delay**: delay emission, like .delay(5, TimeUnit.SECONDS)
- **map**: Transforms the emissions of the observable through a function. Observable.range(1, 10).map{ n -> n / 2 }
- **flatmap**: the output of one observable becomes the input of the other observable and they become one single observable. It introduces a separate observable for each item it emits. The order is disregarded and if one item can be emitted ahead of the other, it will be (use concatMap if order is wanted).
- **combineLatest**: Whenever an update is made to either observable, the latest items from all observables are emitted via a specified function.
```
val o1 = Observable.interval(1, TimeUnit.SECONDS).map { it -> "A$it" }
val o2 = Observable.interval(2, TimeUnit.SECONDS).map { it -> "B$it" }
val observableArray = arrayOf(o1, o2)

val combinedObservable = Observable.combineLatest(observableArray) { args ->
    args.map { it -> it.toString() }
}.subscribe { array ->
    for (item in array) { Log.d(LOG_TAG, item) }
}
```
- **switchOnNext**: Useful if you have an observable of observables! Emits items from the first observable until the second observable can start emitting, then unsubscribes from the first and starts emitting from the second.
- **zip**: Combines observables via a function and emits single items for each combination based on the results of this function. Zip waits for both observables to have emitted before releasing the combined emission.
```
val combinedObservable = Observable.zip(o1, o2, BiFunction { t1: String, t2: String ->
    return@BiFunction "$t1 $t2"
}).subscribe {
    Log.d(LOG_TAG, it)
}

Output
A0 B0
A1 B1
A2 B2
A3 B3
```
- **reduce**: This reduces all the emissions into a single value by sequentially applying a function to them.
```
Observable.just(1, 2, 3, 4, 5)
        .reduce { t1: Int, t2: Int -> t1 * t2 } // Performs 1 * 2 * 3 * 4 * 5
        .subscribe() // Results in 120
```
