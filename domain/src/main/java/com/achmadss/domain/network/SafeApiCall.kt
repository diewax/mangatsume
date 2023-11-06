package com.achmadss.domain.network

import androidx.annotation.Keep
import com.achmadss.domain.DataState
import com.google.gson.Gson
import retrofit2.Response
import java.io.IOException

suspend fun <T> safeApiCall(call: suspend () -> Response<T>): DataState<T> {
    return try {
        val response = call()
        if (response.isSuccessful) {
            val body = response.body() ?: throw IllegalStateException("Body is null")
            DataState.Success(body)
        }
        val errorBody = response.errorBody()?.string() ?: throw IllegalStateException("Error body is null")
        val error = Gson().fromJson(errorBody, ErrorBody::class.java)
        DataState.Error(IOException(error.message))
    } catch (e: Exception) {
        DataState.Error(e)
    }
}

@Keep
data class ErrorBody(
    val message: String
)
