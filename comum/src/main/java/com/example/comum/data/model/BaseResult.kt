package com.example.comum.data.model

import com.example.comum.presentation.adapter.getErrorTypeFromStatusCode
import com.example.comum.presentation.adapter.getStatusCodeFromErrorType
import com.google.gson.annotations.SerializedName

open class BaseResult<TData>(
    /**
     * Dados de retorno, se tiver.
     */
    @SerializedName("Data")
    val data: TData?,
    /**
     * Se o objetivo da requisição foi alcançado.
     */
    @SerializedName("Success")
    val success: Boolean = false,
    /**
     * Não sei nem pra que serve.
     */
    @SerializedName("StatusCode")
    val statusCode: Int,
    /**
     * Mensagem de erro geral.
     */
    @SerializedName("ErrorMessage")
    val errorMessage: String?,
    /**
     * Erros específicos por campos virão aqui.
     */
    @SerializedName("ErrorList")
    val errorList: Map<String, String>? = null,
    /**
     * Tipo do erro interpretado do statusCode.
     */
    val errorType: InternalResultErrorType = InternalResultErrorType.Nenhum
) {
    constructor(
        data: TData? = null,
        success: Boolean = (data != null),
        errorMessage: String? = null,
        errorList: Map<String, String>? = null,
        errorType: InternalResultErrorType = InternalResultErrorType.Nenhum
    ) : this(
        data,
        success,
        getStatusCodeFromErrorType(errorType),
        errorMessage,
        errorList,
        errorType
    )

    constructor(
        data: TData?,
        success: Boolean,
        statusCode: Int,
        errorMessage: String?,
        errorList: Map<String, String>? = null
    ) : this(
        data,
        success,
        statusCode,
        errorMessage,
        errorList,
        getErrorTypeFromStatusCode(statusCode)
    )

    val hasSuccessAndData get() = success && data != null
    val hasSpecificErrors get() = !errorList.isNullOrEmpty()
}