package com.example.signmove.model.req

data class Campaign(
    val images: List<String>,
    val owner: Int,
    val title: String,
    val goal: Int,
    val content: String,
    val region: String,
    val signature: Signature,
    val comment: Comment
)
