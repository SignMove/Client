package com.example.signmove.model.res

data class User(
    val id: Int,
    val email: String,
    val nickname: String,
    val description: String,
    val region: String,
    val image: String
)