package com.boilerplate.kotlin.exceptions

import org.json.JSONObject
import retrofit2.HttpException

class ApiException {
    companion object {
        fun handleApiException(e: Exception): String {
            return when (e) {
                is HttpException -> {
                    val jsonObj = JSONObject(e.response()?.errorBody()?.string() ?: "")
                    try {
                        val message = jsonObj.getString("error")
                        message.ifEmpty {
                            "An unknown error occurred. Please try again later."
                        }
                    } catch (e: Exception) {
                        "An unknown error occurred. Please try again later."
                    }
                }

                else -> "An unknown error occurred. Please try again later."
            }
        }
    }
}


class CustomException(message: String) : Exception(message)

