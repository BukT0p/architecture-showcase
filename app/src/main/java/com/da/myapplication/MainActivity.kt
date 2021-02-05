package com.da.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.da.myapplication.view.posts.PostsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) return
        supportFragmentManager.commit {
            replace(R.id.fragment_container, PostsFragment(), PostsFragment.TAG)
        }
    }
}