package com.boilerplate.kotlin.room.dummy

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Dummy(
    @PrimaryKey
    val isLoggedIn: Boolean
)