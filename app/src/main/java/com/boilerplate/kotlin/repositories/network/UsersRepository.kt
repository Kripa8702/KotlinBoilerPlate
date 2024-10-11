package com.boilerplate.kotlin.repositories.network

import android.util.Log
import com.boilerplate.kotlin.api.ApiService
import com.boilerplate.kotlin.exceptions.ApiException
import com.boilerplate.kotlin.exceptions.CustomException
import com.boilerplate.kotlin.models.response.UsersData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun fetchAllUsers(
       limit: Int
    ): List<UsersData> {

        // Make query params
        val queryMap = mapOf(
            "limit" to limit.toString()
        )

        // Hit API
        return withContext(Dispatchers.IO) {
            try {
                val res = apiService.fetchAllUsers(queryMap)
                if (res.success != false) {
                    res.users ?: throw CustomException("Data not found")
                } else {
                    throw CustomException(res.message ?: "An error occurred")
                }
            } catch (e: CustomException) {
                Log.e("UsersRepository Custom", "fetchFeaturedEvents: ${e.message}")
                throw Exception(e.message)
            } catch (e: Exception) {
                Log.e("UsersRepository", "fetchFeaturedEvents: ${e.message}")
                throw Exception(ApiException.handleApiException(e))
            }
        }
    }
}