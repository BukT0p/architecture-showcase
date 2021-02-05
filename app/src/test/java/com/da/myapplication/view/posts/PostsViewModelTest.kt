package com.da.myapplication.view.posts

import com.da.myapplication.domain.entity.Post
import com.da.myapplication.domain.output.Output
import com.da.myapplication.domain.usecase.GetPostsUseCase
import com.da.myapplication.view.BaseViewModelTest
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class PostsViewModelTest : BaseViewModelTest() {
    private val getPostsUseCase: GetPostsUseCase = mockk()

    @Test
    fun `Loads data on start`() = testDispatcher.runBlockingTest {
        val useCaseResult = listOf(Post(userId = 0, id = 0, title = "", body = ""))
        coEvery { getPostsUseCase.execute(Unit) } coAnswers {
            delay(100L)//simulate network delay
            Output.Success(useCaseResult)
        }
        val viewModel = PostsViewModel(getPostsUseCase)
        //check init state
        assertEquals(PostsListViewState(isLoading = true), viewModel.listStateFlow.value)
        advanceTimeBy(100L)
        assertEquals(PostsListViewState(posts = useCaseResult), viewModel.listStateFlow.value)
    }
}