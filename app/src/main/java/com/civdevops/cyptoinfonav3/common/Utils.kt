package com.civdevops.cyptoinfonav3.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException

fun <T> toResourceFlow(action: suspend () -> T): Flow<Resource<T>> = flow {
    try {
        emit(Resource.Loading())
        val data = action()
        emit(Resource.Success(data))
    } catch (e: HttpException) {
        emit(Resource.Error(message = e.localizedMessage ?: "An Unexpected error occurred!"))
    } catch (e: IOException) {
        emit(Resource.Error(message = "Couldn't reach server. Check your internet connection."))
    } catch (e: Exception) {
        emit(Resource.Error(message = e.localizedMessage ?: "Unexpected error!"))
    }
}.flowOn(Dispatchers.IO)