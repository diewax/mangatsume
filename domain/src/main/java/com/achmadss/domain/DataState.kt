package com.achmadss.domain

sealed class DataState<out T> {
    object OnLoading : DataState<Nothing>()
    data class OnData<out Result>(val data: Result) : DataState<Result>()
    data class OnFailure(val error: Throwable?) : DataState<Nothing>()
}