package com.da.myapplication.domain.repo

import com.da.myapplication.domain.entity.Post
import com.da.myapplication.domain.output.Output

interface PostsRemoteRepo {
    suspend fun getPosts(): Output<List<Post>>

    suspend fun getPostById(id: Long): Output<Post?>
}