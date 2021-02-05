package com.da.myapplication.view.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.da.myapplication.domain.output.Output
import com.da.myapplication.domain.usecase.GetPostsUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class PostsViewModel(
    private val postsUseCase: GetPostsUseCase
) : ViewModel() {
    private var loadPostsJob: Job? = null
    private val errorMSF = MutableSharedFlow<String?>()
    val errorFlow = errorMSF.asSharedFlow()

    private val listMSF = MutableStateFlow(PostsListViewState(isLoading = true))
    val listStateFlow = listMSF.asStateFlow()

    init {
        loadPosts()
    }

    fun refreshPosts() {
        loadPosts()
    }

    fun onItemClicked(postId: Long) {
        viewModelScope.launch {
            errorMSF.emit("show post for $postId")
        }
    }

    private fun loadPosts() {
        if (loadPostsJob?.isActive == true) return
        loadPostsJob = viewModelScope.launch {
            listMSF.value = listMSF.value.copy(isLoading = true)
            when (val output = postsUseCase.execute(Unit)) {
                is Output.Success -> {
                    listMSF.value = PostsListViewState(posts = output.result, isLoading = false)
                }
                is Output.Exception -> {
                    Timber.e(output.exception, "Load posts failed")
                    errorMSF.emit(output.exception.message)
                    listMSF.value = listMSF.value.copy(isLoading = false)
                }
            }
        }
    }
}