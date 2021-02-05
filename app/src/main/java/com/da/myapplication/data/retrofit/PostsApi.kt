package com.da.myapplication.data.retrofit

import com.da.myapplication.data.dto.PostDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsApi {
    @GET("/posts")
    suspend fun getPosts(): List<PostDTO>

    @GET("/post/{id}")
    suspend fun getPostById(@Path("id") id: Long): List<PostDTO>
}