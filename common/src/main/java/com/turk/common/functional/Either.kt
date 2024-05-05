package com.turk.common.functional


sealed class Either<out E, out R> {
    data class Error<out E>(val error: E) : Either<E, Nothing>()

    data class Result<out R>(val response: R) : Either<Nothing, R>()
    object Loading : Either<Nothing, Nothing>()

    fun <E> error(a: E) = Error(a)
    fun <R> result(b: R) = Result(b)
    fun <R> loading(b: R) = Loading

    fun either(onError: (E) -> Any, onResult: (R) -> Unit,onLoading:()->Unit): Any =
        when (this) {
            is Error -> onError(error)
            is Result -> onResult(response)
            is Loading -> onLoading()
        }

}


