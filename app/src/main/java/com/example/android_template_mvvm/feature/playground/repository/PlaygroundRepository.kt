package com.example.android_template_mvvm.feature.playground.repository

import com.example.android_template_mvvm.core.base.BaseRepository
import javax.inject.Inject

class PlaygroundRepository @Inject constructor(private val remoteDataSource: PlaygroundRemoteDataSource) :
    BaseRepository() {
    fun fetch() = remoteDataSource.fetch()
}