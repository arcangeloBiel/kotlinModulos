package com.example.comum.presentation.adapter

import com.example.comum.data.model.BaseResult
import com.example.comum.data.model.InternalResultErrorType
import com.google.gson.Gson
import retrofit2.HttpException
import retrofit2.Response
import kotlin.reflect.KClass


inline fun <TData, reified TResult : BaseResult<TData>> baseResultFromBaseResultResponse(
    response: Response<TResult>
): BaseResult<TData> {

    val baseResult = baseResultFromResponse(
        response,
        TResult::class
    )

    val errorMessage =
        if (baseResult?.errorMessage.isNullOrBlank()) response.message()
        else baseResult?.errorMessage

    val success = if (baseResult?.success == false) false else baseResult?.data != null
    val statusCode = baseResult?.statusCode ?: response.code()

    return BaseResult(
        baseResult?.data,
        success,
        statusCode,
        errorMessage,
        baseResult?.errorList
    )
}

/**
 * Tenta pegar um body que é um base result de dentro da response.
 */
inline fun <TData, reified TResult : BaseResult<TData>> baseResultFromResponse(
    response: Response<TResult>,
    kClass: KClass<TResult>
): BaseResult<TData>? {

    var body = response.body()

    val errorBody = response.errorBody()
    val errorBodyString = errorBody?.string()

    if (body == null && !errorBodyString.isNullOrBlank()) {
        val gson = Gson()
        body = gson.fromJson(errorBodyString, kClass.java)
    }

    return body
}

fun getStatusCodeFromErrorType(errorType: InternalResultErrorType): Int {
    return when (errorType) {
        InternalResultErrorType.Nenhum -> 200
        InternalResultErrorType.BadRequest -> 400
        InternalResultErrorType.ServerError -> 500
        else -> 0
    }
}

fun <TData> baseResultFromResponseException(
    httpEx: HttpException
): BaseResult<TData> {
    val response = httpEx.response()
    val errorMessage: String? = response?.message() ?: httpEx.message ?: "Erro não especificado"
    val statusCode = response?.code() ?: httpEx.code()
    return BaseResult(null, false, statusCode, errorMessage)
}

fun getErrorTypeFromStatusCode(statusCode: Int): InternalResultErrorType {
    return when (statusCode) {
        in 200..399 -> InternalResultErrorType.Nenhum
        in 400..499 -> InternalResultErrorType.BadRequest
        in 500..503 -> InternalResultErrorType.ServerError
        else -> InternalResultErrorType.AppError
    }
}