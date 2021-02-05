package com.da.myapplication.data.retrofit

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.koin.core.component.get
import retrofit2.Retrofit
import kotlin.test.assertTrue

class PostsApiTest : BaseApiTest() {
    private val postsApi: PostsApi by lazy { get<Retrofit>().create(PostsApi::class.java) }

    @Test
    fun `Loads list of latest posts`() = runBlocking {
        val posts = postsApi.getPosts()
        assertTrue(posts.isNotEmpty())
    }
}