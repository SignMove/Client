package com.example.signmove.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val email: String,
    val nickname: String,
    val description: String,
    val region: String,
    val image: String
): Parcelable

data class GetUser(
    val exists: Boolean,
    val user: User?
)

data class SetUser(
    val email: String,
    val nickname: String,
    val description: String,
    val region: String,
    val image: String
)

data class Sibal(
    val updated: Boolean
)