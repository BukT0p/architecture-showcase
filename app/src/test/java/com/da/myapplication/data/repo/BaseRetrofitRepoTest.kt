package com.da.myapplication.data.repo

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

abstract class BaseRetrofitRepoTest {
    val io: CoroutineDispatcher = Dispatchers.Unconfined
}