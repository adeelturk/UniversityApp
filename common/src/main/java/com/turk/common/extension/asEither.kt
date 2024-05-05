package com.turk.common.extension

import android.util.Log
import com.turk.common.error.ErrorEntity
import kotlinx.coroutines.flow.map
import com.turk.common.functional.Either
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart


fun <T> Flow<T>.asEither(): Flow<Either<ErrorEntity,T>> {
    return this
        .map<T, Either<ErrorEntity,T>> {
            Either.Result(it)
        }
        .onStart { emit(Either.Loading) }
        .catch() {
            it.printStackTrace()
            emit(Either.Error(ErrorEntity.Unknown(it))) }
}


fun <T,R> Flow<T>.asEither(transform: (T) -> R): Flow<Either<ErrorEntity,R>> {
    return this
        .map<T, Either<ErrorEntity,R>> {
            Either.Result(transform(it))
        }
        .onStart { emit(Either.Loading) }
        .catch {
            emit(Either.Error(ErrorEntity.Unknown(it))) }
}