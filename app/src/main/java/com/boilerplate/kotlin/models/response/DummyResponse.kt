package com.boilerplate.kotlin.models.response

data class DummyResponse(
    val success: Boolean,
    val message: String,
    val data: DummyData? = null
)


data class DummyData(
    val id: Int,
    val name: String,
    val email: String,
    val username: String,
    val description: String
)