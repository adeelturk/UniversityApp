package com.turk.network

import android.util.Log
import com.turk.common.error.ErrorEntity
import com.turk.common.functional.Either
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call


/**
 * Takes in a transform lambda to return a modified version of the responses
 */

var generalErrorImplementation = GeneralErrorImplementation()

@Suppress("unused")
fun <T, R> Call<T>.requestBlocking(transform: (T) -> R): Either<ErrorEntity, R> {
    return try {
        val response = execute()
        response.errorBody()
        when (response.isSuccessful) {
            true -> Either.Result(transform(response.body()!!))

            false -> Either.Error(generalErrorImplementation.getHttpErrors(response))
        }
    } catch (exception: Throwable) {

        Either.Error(generalErrorImplementation.getError(exception))

    }

}

@Suppress("unused")
fun <T, R> Call<T>.requestBlockingFlow(
    transform: (T) -> R)
: Flow<Either<ErrorEntity, R>> {

    return flow {
        try {

            val response = execute()
            when (response.isSuccessful) {

                true -> {
                    emit(Either.Result(transform(response.body()!!)))
                }
                false -> {
                    emit(Either.Error(generalErrorImplementation.getHttpErrors(response)))
                }
            }
        } catch (exception: Throwable) {
            Log.v("adeel","step5 ${exception}")
            emit(Either.Error(generalErrorImplementation.getError(exception)))
        }
    }

}
















