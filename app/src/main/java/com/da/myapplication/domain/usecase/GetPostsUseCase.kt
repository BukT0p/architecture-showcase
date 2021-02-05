package com.da.myapplication.domain.usecase

import com.da.myapplication.domain.entity.Post
import com.da.myapplication.domain.output.Output
import com.da.myapplication.domain.repo.PostsRemoteRepo

class GetPostsUseCase(
    private val postsRemoteRepo: PostsRemoteRepo
) : UseCase<Unit, Output<List<Post>>>() {

    override suspend fun execute(input: Unit) =
        postsRemoteRepo.getPosts()
}