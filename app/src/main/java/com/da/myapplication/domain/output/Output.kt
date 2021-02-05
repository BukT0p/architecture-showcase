package com.da.myapplication.domain.output

sealed class Output<T> {
    class Success<T>(val result: T) : Output<T>()

    class Exception<T>(val exception: Throwable) : Output<T>()
}