package com.example.comum.data.interceptors

import com.example.comum.domain.helpers.customErrorResponse
import com.example.comum.domain.helpers.errorResponse
import okhttp3.Interceptor
import okhttp3.Response



class ErrorInterceptor  : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        try {
            val retorno = chain.proceed(request)
            if(retorno.isSuccessful){
                return  retorno
            }
            return  retorno
            return customErrorResponse(retorno.message() , request)
        }catch (t:Throwable){
            return errorResponse(t, request)
        }
    }
}