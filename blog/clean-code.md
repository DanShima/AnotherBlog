---
title: Clean code
description: characteristics of clean code
date: 2019-05-05
tags: ['Programming']
---

## Characteristics of clean code

- **Your code should be elegant:** Your code should make you smile the way a well-crafted music box or well-designed car would.
- **Your code has been taken care of:** Someone has taken the time to keep it simple and orderly. They have paid appropriate attention to details. They have cared.
- **Your code has to be focused:** Each function, each class, each module exposes a single-minded attitude that remains entirely focused, and unpolluted, by the surrounding details.
- **Contains no duplication**
- **Runs all the tests**
- **Minimize the number of entities such as classes, methods, functions, and the like.**


### classes should have Single Responsibility
Example: inside your activity, you need to implement SearchView.OnClickListener(), which has 3 methods but you only need the onSubmit()method.


```
interface SearchViewCallback {
    fun onSubmit(query: String?)
}
class SearchViewClickListener(val callback: SearchViewCallback): SearchView.OnClickListener {
    override fun onSubmit(query: String?): Boolean {
        callback.onSubmit(query)
        return true
    }
    override fun onChange(query: String?): Boolean {
        return false    }
}


val listener = SearchViewClickListener(
    object : SearchViewCallback {
        override fun onSubmit(query: String?) {
            // Do the magic here
            }
    })
searchView.setOnClickListener(listener)```
