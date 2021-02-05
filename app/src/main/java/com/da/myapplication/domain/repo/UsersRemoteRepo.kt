package com.da.myapplication.domain.repo

import com.da.myapplication.domain.entity.User
import com.da.myapplication.domain.output.Output

interface UsersRemoteRepo {
    suspend fun getUserById(userId: Long): Output<User?>
}