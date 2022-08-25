package com.example.android_template_mvvm.feature.playground.repository

import com.example.android_template_mvvm.core.base.BaseRemoteDataSource
import com.example.android_template_mvvm.feature.playground.model.PlaygroundModel
import com.example.android_template_mvvm.feature.playground.ui.PlaygroundViewModel
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class PlaygroundRemoteDataSource @Inject constructor() : BaseRemoteDataSource() {

    fun fetch(): Flow<PlaygroundModel> = flow {
        val endpoint = "posts/1"
        val response: PlaygroundModel = client.get {
            url(endpoint)
        }.body()
        emit(response)
    }.flowOn(Dispatchers.IO)
}