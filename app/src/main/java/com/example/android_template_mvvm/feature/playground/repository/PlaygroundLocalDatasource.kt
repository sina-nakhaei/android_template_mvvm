package com.example.android_template_mvvm.feature.playground.repository

import android.content.Context
import com.example.android_template_mvvm.core.base.BaseLocalDatasource
import com.example.android_template_mvvm.feature.playground.model.PlaygroundEntity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PlaygroundLocalDatasource
@Inject constructor(@ApplicationContext private val context: Context) :
    BaseLocalDatasource(context) {

    fun insertPlayground(playgroundEntity: PlaygroundEntity) {
        databaseHandler.insertPlayground(playgroundEntity)
    }

    fun getPlayground(): PlaygroundEntity = databaseHandler.getPlayground()
}