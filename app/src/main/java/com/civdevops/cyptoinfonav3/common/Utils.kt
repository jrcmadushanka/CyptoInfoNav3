package com.civdevops.cyptoinfonav3.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun <T> toResourceFlow(action: suspend () -> T): Flow<Resource<T>> = flow {
    try {
        emit(Resource.Loading())
        val data = action()
        emit(Resource.Success(data))
    } catch (e: HttpException) {
        emit(Resource.Error(message = e.localizedMessage ?: "An Unexpected error occurred!"))
    } catch (_: IOException) {
        emit(Resource.Error(message = "Couldn't reach server. Check your internet connection."))
    }
}.flowOn(Dispatchers.IO)

fun formatDate(date: String, format: String): String? =
    try {
        val parsedDate = ZonedDateTime.parse(date)
        val dateFormatter = DateTimeFormatter.ofPattern(format)
        return parsedDate.format(dateFormatter)
    } catch (_: Exception){
        return null
    }