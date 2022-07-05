package com.github.astat1cc.sergeybalakintesttask.core.utils

sealed class FetchResult<T> {

    class Success<T>(val data: T) : FetchResult<T>()
    class Error<T>(val message: String?) : FetchResult<T>()
}