package com.da.myapplication.view.posts

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.da.myapplication.databinding.LiPostBinding
import com.da.myapplication.domain.entity.Post

class PostViewHolder(
    view: View,
    private val click: (Long) -> Unit
) : RecyclerView.ViewHolder(view) {

    private val binding = LiPostBinding.bind(view)
    private var postId: Long
        get() = binding.root.tag as Long
        set(value) {
            binding.root.tag = value
        }

    init {
        binding.root.setOnClickListener { click(postId) }
    }

    fun bind(post: Post) {
        postId = post.id
        binding.title.text = post.title
        binding.body.text = post.body
    }
}
