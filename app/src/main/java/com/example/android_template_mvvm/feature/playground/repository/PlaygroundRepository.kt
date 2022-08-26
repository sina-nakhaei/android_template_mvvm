package com.example.android_template_mvvm.feature.playground.repository

import com.example.android_template_mvvm.core.base.BaseRepository
import com.example.android_template_mvvm.feature.playground.model.PlaygroundEntity
import com.example.android_template_mvvm.feature.playground.model.PlaygroundModel
import com.example.android_template_mvvm.feature.playground.model.toEntity
import com.example.android_template_mvvm.feature.playground.model.toModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class PlaygroundRepository @Inject constructor(
    private val remoteDataSource: PlaygroundRemoteDataSource,
    private val localDatasource: PlaygroundLocalDatasource,
) :
    BaseRepository() {
    fun getPlayground(): PlaygroundModel=
        runBlocking {
            val playground = remoteDataSource.fetch().first()
            localDatasource.insertPlayground(playground.toEntity())
            localDatasource.getPlayground().toModel()
        }
}