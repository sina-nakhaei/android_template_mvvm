package com.example.android_template_mvvm.core.base

import io.ktor.client.*
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

abstract class BaseRemoteDataSource {
    @Inject
    lateinit var client: HttpClient

    val dispatcher = Dispatchers.IO
}