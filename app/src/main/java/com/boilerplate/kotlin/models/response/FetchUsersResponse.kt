package com.boilerplate.kotlin.models.response

/** According to the normal response convention:
 * {
 *  "success": true,
 *  "message": "Data found",
 *  "users": [
 *      ...
 *      ]
 *  }
 *
 * "success" and "message" are made nullable as of now to accommodate the dummy API but
 * in a real world scenario, they should be non-nullable.
 *
 *  For a different response body, you can change the params accordingly and make sure
 *  to update the repository code to reflect that change.
 */

data class FetchUsersResponse(
    val success: Boolean?,
    val message: String?,
    val users: List<UsersData>?
)


data class UsersData(
    val id: Int,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val image: String?,
    val age: Int?,
)