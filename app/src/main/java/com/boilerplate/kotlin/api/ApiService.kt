package com.boilerplate.kotlin.api

import com.boilerplate.kotlin.models.request.DummyRequest
import com.boilerplate.kotlin.models.response.DummyResponse
import com.boilerplate.kotlin.utils.Constants
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface ApiService {

    @Headers(
        "Accept: application/json"
    )
    @GET(Constants.DUMMY_PATH)
    suspend fun fetchDummy(@Body dummyRequest: DummyRequest): DummyResponse

    /// @QueryMap queryMap: Map<String, String> for query parameters

}