package com.da.myapplication.view.posts

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.da.myapplication.R
import com.da.myapplication.databinding.FragmentPostsBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostsFragment : Fragment(R.layout.fragment_posts) {

    private val postsVM: PostsViewModel by viewModel()
    private val postsAdapter = PostsAdapter { postsVM.onItemClicked(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPostsBinding.bind(view)
        binding.swipeRefreshLayout.setOnRefreshListener {
            postsVM.refreshPosts()
        }
        binding.recyclerView.adapter = postsAdapter
        postsVM.errorFlow.onEach { showError(it) }.launchIn(lifecycleScope)
        lifecycleScope.launchWhenResumed {
            postsVM.listStateFlow.collect { showListState(it, binding) }
        }
    }

    private fun showError(error: String?) {
        Toast.makeText(requireContext(), error ?: "Something went wrong", Toast.LENGTH_SHORT).show()
    }

    private fun showListState(viewState: PostsListViewState, binding: FragmentPostsBinding) {
        binding.swipeRefreshLayout.isRefreshing = viewState.isLoading
        postsAdapter.submitList(viewState.posts)
    }

    companion object {
        const val TAG = "PostsFragment"
    }
}