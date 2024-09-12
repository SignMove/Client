package com.example.signmove.model

data class News(
    val id: Int,
    val created_at: String,
    val image: String,
    val title: String,
    val content: String,
    val comment: String,
    val comment_id_increment: Int
)
