package com.example.fyp

data class Post(
    val imageResId: Int,
    val description: String,
    val likeIconResId: Int,
    val commentIconResId: Int,
    val shareIconResId: Int,
    var isLiked: Boolean = false // Track like status
)


