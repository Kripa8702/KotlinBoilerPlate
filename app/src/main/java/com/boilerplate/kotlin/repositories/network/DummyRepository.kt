package com.boilerplate.kotlin.repositories.network

import android.util.Log
import com.boilerplate.kotlin.api.ApiService
import com.boilerplate.kotlin.exceptions.ApiException
import com.boilerplate.kotlin.exceptions.CustomException
import com.boilerplate.kotlin.models.request.DummyRequest
import com.boilerplate.kotlin.models.response.DummyData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DummyRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun fetchDummy(
        email: String,
        password: String
    ): DummyData {

        // Make request
        val request = DummyRequest(
            email = email,
            password = password
        )

        // Hit API
        return withContext(Dispatchers.IO) {
            try {
                val res = apiService.fetchDummy(dummyRequest = request)
                if (res.success) {
                    res.data ?: throw CustomException("Data not found")
                } else {
                    throw CustomException(res.message)
                }
            } catch (e: CustomException) {
                Log.e("EventsRepository Custom", "fetchFeaturedEvents: ${e.message}")
                throw Exception(e.message)
            } catch (e: Exception) {
                Log.e("EventsRepository", "fetchFeaturedEvents: ${e.message}")
                throw Exception(ApiException.handleApiException(e))
            }
        }
    }
}