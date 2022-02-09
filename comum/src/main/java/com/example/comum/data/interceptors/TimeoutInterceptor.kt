package com.example.comum.data.interceptors

import com.example.comum.domain.helpers.SpecificTimeout
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation
import java.io.IOException



internal class TimeoutInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response? {

        val request = chain.request()
        val tag = request.tag(Invocation::class.java)

        val timeout: SpecificTimeout? =
            tag?.method()?.getAnnotation(SpecificTimeout::class.java)

        if (timeout == null) return chain.proceed(request)

        return chain.withReadTimeout(timeout.duration, timeout.unit)
            .withConnectTimeout(timeout.duration, timeout.unit)
            .withWriteTimeout(timeout.duration, timeout.unit)
            .proceed(request)
        return null
    }
}