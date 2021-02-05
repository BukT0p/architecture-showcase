package com.da.myapplication.domain.usecase

import com.da.myapplication.domain.entity.Post
import com.da.myapplication.domain.output.Output
import com.da.myapplication.domain.repo.PostsRemoteRepo
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GetPostsUseCaseTest {
    @Test
    fun `Should pass data without modification`() = runBlocking {
        val expected = listOf(Post(userId = 1, id = 2, title = "", body = ""))
        val mockRepo: PostsRemoteRepo = mockk()
        coEvery { mockRepo.getPosts() } returns Output.Success(expected)
        val output = GetPostsUseCase(mockRepo).execute(Unit)
        assertTrue(output is Output.Success)
        assertEquals(expected, output.result)
    }
}