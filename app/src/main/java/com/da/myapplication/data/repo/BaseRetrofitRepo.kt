package com.da.myapplication.data.repo

import com.da.myapplication.domain.output.Output
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

abstract class BaseRetrofitRepo(
    private val io: CoroutineDispatcher,
) {
    internal suspend fun <T, R> executeRequest(
        request: suspend () -> T,
        success: (T) -> R
    ): Output<R> = withContext(io) {
        try {
            val response: T = request()
            Output.Success(success(response))
        } catch (httpe: HttpException) {
            Output.Exception<R>(httpe)
        } catch (ioe: IOException) {
            Output.Exception<R>(ioe)
        } catch (e: Throwable) {
            Output.Exception<R>(e)
        }
    }
}