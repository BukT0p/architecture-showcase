package com.da.myapplication.data.converter

import com.da.myapplication.data.dto.PostDTO
import com.da.myapplication.domain.entity.Post

fun PostDTO.toEntity() = Post(
    id = id,
    userId = userId,
    title = title,
    body = body
)