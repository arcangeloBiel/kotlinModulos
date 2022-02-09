package com.example.comum.domain.helpers

import okhttp3.*

internal fun noConectivityResponse(original: Request): Response {
    val message = "Você está sem conexão com internet."
    val statusCode = 503
    return createResponse(
        statusCode,
        message,
        original
    )
}

internal fun errorResponse(ex: Throwable, original: Request): Response {
    val message = ex.message ?: "Request error"
    val statusCode = 500
    return createResponse(
        statusCode,
        "[error-response] $message",
        original
    )
}

internal fun customErrorResponse(message: String, original: Request): Response {
    val statusCode = 403
    return createResponse(
        statusCode,
        "[custom-error-response] $message",
        original
    )
}

internal fun expiredTokenResponse(original: Request): Response {
    val statusCode = 401
    val message = "Por favor, entre novamente."
    return createResponse(
        statusCode,
        message,
        original
    )
}

internal fun tokenNotFoundResponse(original: Request): Response {
    val message = "Necessário login para acessar a função"
    val statusCode = 401
    return createResponse(
        statusCode,
        message,
        original
    )
}

internal fun unableToRefreshTokenResponse(original: Request): Response {
    val message = "Não foi possivel renovar o token de acesso, favor fazer login novamente"
    val statusCode = 401
    return createResponse(
        statusCode,
        message,
        original
    )
}

internal fun errorToRefreshTokenResponse(original: Request): Response {
    val message = "Não foi possivel renovar o token de acesso, favor tente novamente"
    val statusCode = 500
    return createResponse(
        statusCode,
        message,
        original
    )
}

internal fun noTokenResponse(original: Request): Response {
    val statusCode = 401
    val message = "Usuário precisa realizar autenticação"
    return createResponse(
        statusCode,
        message,
        original
    )
}

internal fun createResponse(
    statusCode: Int,
    message: String,
    original: Request
): Response {
    return Response.Builder()
        .code(statusCode)
        .protocol(Protocol.HTTP_2)
        .body(emptyRequestBody)
        .message(message)
        .request(original)
        .build()
}

val emptyRequestBody: ResponseBody =
    ResponseBody.create(
        MediaType.parse("application/json"),
        ""
    )