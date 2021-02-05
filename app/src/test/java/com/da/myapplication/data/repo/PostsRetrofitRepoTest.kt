package com.da.myapplication.data.repo

import com.da.myapplication.data.dto.PostDTO
import com.da.myapplication.data.retrofit.PostsApi
import com.da.myapplication.domain.entity.Post
import com.da.myapplication.domain.output.Output
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PostsRetrofitRepoTest : BaseRetrofitRepoTest() {
    private val postsApi: PostsApi = mockk()

    @Test
    fun `Get posts`() = runBlocking {
        val apiResponse = listOf(PostDTO(userId = 0, id = 0, title = "", body = ""))
        val expectedResult = listOf(Post(userId = 0, id = 0, title = "", body = ""))
        coEvery { postsApi.getPosts() } answers { apiResponse }
        val result = PostsRetrofitRepo(postsApi, io).getPosts()
        assertTrue(result is Output.Success)
        assertEquals(expectedResult, result.result)
    }
}