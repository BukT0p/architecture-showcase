package com.da.myapplication.data.retrofit

import com.da.myapplication.di.BG
import com.da.myapplication.di.IO
import com.da.myapplication.di.UI
import com.da.myapplication.di.networkClientModule
import kotlinx.coroutines.Dispatchers
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

class KoinNetworkExtension : BeforeAllCallback, AfterAllCallback {

    override fun beforeAll(context: ExtensionContext?) {
        startKoin {
            modules(
                module {
                    single(UI) { Dispatchers.Unconfined }
                    single(IO) { Dispatchers.Unconfined }
                    single(BG) { Dispatchers.Unconfined }
                },
                networkClientModule
            )
        }
    }

    override fun afterAll(context: ExtensionContext?) {
        stopKoin()
    }
}