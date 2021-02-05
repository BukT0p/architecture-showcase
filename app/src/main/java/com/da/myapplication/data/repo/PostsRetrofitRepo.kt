package com.da.myapplication.data.repo

import com.da.myapplication.data.converter.toEntity
import com.da.myapplication.data.retrofit.PostsApi
import com.da.myapplication.domain.entity.Post
import com.da.myapplication.domain.output.Output
import com.da.myapplication.domain.repo.PostsRemoteRepo
import kotlinx.coroutines.CoroutineDispatcher

class PostsRetrofitRepo(
    private val postsApi: PostsApi,
    io: CoroutineDispatcher
) : PostsRemoteRepo, BaseRetrofitRepo(io) {

    override suspend fun getPosts(): Output<List<Post>> =
        executeRequest(
            request = { postsApi.getPosts() },
            success = { list -> list.map { it.toEntity() } }
        )

    override suspend fun getPostById(id: Long): Output<Post?> =
        executeRequest(
            request = { postsApi.getPostById(id) },
            success = { list -> list.firstOrNull()?.toEntity() }
        )
}