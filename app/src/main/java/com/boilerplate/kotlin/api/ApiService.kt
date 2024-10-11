package com.boilerplate.kotlin.api

import com.boilerplate.kotlin.models.response.FetchUsersResponse
import com.boilerplate.kotlin.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface ApiService {

    @Headers(
        "Content-Type: application/json"
    )
    @GET(Constants.USERS_PATH)
    suspend fun fetchAllUsers(@QueryMap queryMap: Map<String, String>): FetchUsersResponse


    /** In case of POST request with request body, do this:
     *
     * @POST(Constants.USERS_PATH)
     * suspend fun fetchAllUsers(@Body fetchUsersRequest: FetchUsersRequest): FetchUsersResponse
     */
}