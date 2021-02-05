package com.da.myapplication.domain.entity

data class User(
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val phone: String?,
    val website: String?,
    val address: Address?,
    val company: Company?
)