package com.da.myapplication.domain.entity

data class Post(
    val userId: Long,
    val id: Long,
    val title: String,
    val body: String
)