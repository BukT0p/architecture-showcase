package com.da.myapplication.view.posts

import com.da.myapplication.domain.entity.Post

data class PostsListViewState(val posts: List<Post> = emptyList(), val isLoading: Boolean = false)