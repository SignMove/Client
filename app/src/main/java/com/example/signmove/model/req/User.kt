package com.example.signmove.model.req

data class User(
    val email: String,
    val nickname: String,
    val description: String,
    val region: String,
    val image: String
)