package com.example.android_template_mvvm.core.database

import android.content.Context
import com.example.android_template_mvvm.feature.playground.model.PlaygroundEntity
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking


class DatabaseHandler(@ApplicationContext private val context: Context) {

    private val database: AppDatabase
        get() = AppDatabase.invoke(context)

    companion object {
        @Volatile
        private var instance: DatabaseHandler? = null

        @JvmStatic
        fun getInstance(@ApplicationContext context: Context): DatabaseHandler {
            if (instance == null) {
                synchronized(this) {
                    instance ?: DatabaseHandler(context)
                        .also { dbHandler -> instance = dbHandler }
                }
            }

            return instance!!
        }
    }

    fun insertPlayground(playgroundEntity: PlaygroundEntity) = runBlocking {
        database.playgroundDao.insert(playgroundEntity)
    }

    fun getPlayground(): PlaygroundEntity = runBlocking {
        database.playgroundDao.getPlayground().first()
    }
}
