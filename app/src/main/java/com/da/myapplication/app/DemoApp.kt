package com.da.myapplication.app

import android.app.Application
import com.da.myapplication.di.appModule
import com.da.myapplication.di.networkClientModule
import com.da.myapplication.di.postsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DemoApp)
            modules(appModule, networkClientModule, postsModule)
        }
    }
}