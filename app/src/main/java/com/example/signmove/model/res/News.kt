package com.example.signmove.model.res

data class News(
    val id: Int,
    val createdAt: String,
    val image: String,
    val title: String,
    val content: String,
    val comment: Comment
)
