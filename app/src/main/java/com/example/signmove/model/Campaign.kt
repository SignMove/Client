package com.example.signmove.model

data class Campaign(
    val id: Int,
    val createdAt: String,
    val images: List<String>,
    val owner: Int,
    val title: String,
    val goal: Int,
    val content: String,
    val region: String,
    val signature: Signature,
    val comment: Comment
)
