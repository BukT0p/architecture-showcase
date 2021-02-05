package com.da.myapplication.data.converter

import com.da.myapplication.data.dto.PostDTO
import com.da.myapplication.domain.entity.Post
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PostConverterKtTest {
    @Test
    fun `Converts DTO to Entity`() {
        val expected = Post(userId = 1, id = 2, title = "title", body = "body")
        val given = PostDTO(userId = 1, id = 2, title = "title", body = "body")
        assertEquals(expected, given.toEntity())
    }
}