package com.da.myapplication.data.retrofit

import com.da.myapplication.data.dto.UserDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("/users")
    suspend fun getUsers(): List<UserDTO>

    @GET("/users/{id}")
    suspend fun getUserById(@Path("id") userId: Long): List<UserDTO>
}