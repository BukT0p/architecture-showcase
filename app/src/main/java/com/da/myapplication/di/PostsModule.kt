package com.da.myapplication.di

import com.da.myapplication.data.repo.PostsRetrofitRepo
import com.da.myapplication.data.retrofit.PostsApi
import com.da.myapplication.domain.repo.PostsRemoteRepo
import com.da.myapplication.domain.usecase.GetPostsUseCase
import com.da.myapplication.view.posts.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val postsModule = module {
    single<PostsApi> { get<Retrofit>().create(PostsApi::class.java) }

    factory<PostsRemoteRepo> { PostsRetrofitRepo(get(), get(IO)) }

    factory { GetPostsUseCase(get()) }

    viewModel { PostsViewModel(get()) }
}