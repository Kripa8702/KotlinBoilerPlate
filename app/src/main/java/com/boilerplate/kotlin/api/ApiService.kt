package com.boilerplate.kotlin.api

import com.boilerplate.kotlin.models.request.FetchUsersRequest
import com.boilerplate.kotlin.models.response.FetchUsersResponse
import com.boilerplate.kotlin.utils.Constants
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers(
        "Content-Type: application/json"
    )
    @GET(Constants.USERS_PATH)
    suspend fun fetchAllUsers(@Body fetchUsersRequest: FetchUsersRequest): FetchUsersResponse
}