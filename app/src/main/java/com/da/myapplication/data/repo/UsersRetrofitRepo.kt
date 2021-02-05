package com.da.myapplication.data.repo

import com.da.myapplication.data.converter.toEntity
import com.da.myapplication.data.retrofit.UserApi
import com.da.myapplication.domain.entity.User
import com.da.myapplication.domain.output.Output
import com.da.myapplication.domain.repo.UsersRemoteRepo
import kotlinx.coroutines.CoroutineDispatcher

class UsersRetrofitRepo(
    private val userApi: UserApi,
    io: CoroutineDispatcher
) : UsersRemoteRepo, BaseRetrofitRepo(io) {

    override suspend fun getUserById(userId: Long): Output<User?> =
        executeRequest(
            request = { userApi.getUserById(userId) },
            success = { list -> list.firstOrNull()?.toEntity() }
        )
}