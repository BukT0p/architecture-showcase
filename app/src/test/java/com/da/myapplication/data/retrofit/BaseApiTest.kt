package com.da.myapplication.data.retrofit

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.extension.ExtendWith
import org.koin.test.KoinTest

@ExtendWith(KoinNetworkExtension::class)
abstract class BaseApiTest : KoinTest {
}
