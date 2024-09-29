package com.boilerplate.kotlin.interceptors

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class LoggingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val requestBody = request.body

        if (requestBody != null) {
            val buffer = okio.Buffer()
            requestBody.writeTo(buffer)
            val requestBodyString = buffer.readUtf8()
            val requestLog =
                "--> ${request.method} ${request.url} \nRequest body: $requestBodyString"
            Log.i("Retrofit", requestLog)
        } else {
            val requestLog = "--> ${request.method} ${request.url} \nRequest body: None"
            Log.i("Retrofit", requestLog)
        }

        val response = chain.proceed(request)

        val responseBody = response.peekBody(1024).string() // Read limited response body
        val responseLog =
            "<-- ${response.code} ${response.message} \nResponse body: $responseBody"
        Log.i("Retrofit", responseLog)

        if (!response.isSuccessful) {
            Log.e("Retrofit", "Response failed with code: ${response.code}")
        }

        return response
    }
}