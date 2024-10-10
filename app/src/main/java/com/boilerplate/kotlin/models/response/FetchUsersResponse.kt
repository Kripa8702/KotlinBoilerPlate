package com.boilerplate.kotlin.models.response

data class FetchUsersResponse(
    val success: Boolean,
    val message: String,
    val users: List<UsersData>?
)


data class UsersData(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val image: String,
    val age: Int,
)