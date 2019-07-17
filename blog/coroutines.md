---
title: Understanding Coroutines
description: Understanding Coroutines
date: 2019-07-10
---

## Understanding Coroutines

Conceptually, coroutines are like threads, executing units of work concurrently. But unlike threads, coroutines aren’t necessarily bound to any particular thread.

A coroutine can start executing in one thread, suspend execution, and resume on a different thread.

Coroutines are managed at the user space level by the Kotlin Runtime. That means there is no time slice allocated to a coroutine to perform a unit of work. That also means there’s no scheduler overhead. Instead, coroutines perform cooperative multitasking. When one coroutine hits a suspension point, the Kotlin Runtime will find another coroutine to resume. You can think of this like having multiple coroutines multiplexed on to a single thread.

Coroutines have a small memory footprint — a few dozen bytes. That gives you a very high level of concurrency with very little overhead.

### Resources
https://proandroiddev.com/kotlin-coroutines-channels-csp-android-db441400965f