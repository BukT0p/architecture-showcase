package com.da.myapplication.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val BG = named("bg")
val IO = named("io")
val UI = named("ui")

val appModule = module {

    single<CoroutineDispatcher>(UI) { Dispatchers.Main }

    single(IO) { Dispatchers.IO }

    single(BG) { Dispatchers.Default }

}