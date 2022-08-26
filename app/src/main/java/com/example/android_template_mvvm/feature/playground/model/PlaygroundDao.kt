package com.example.android_template_mvvm.feature.playground.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaygroundDao {
    @Insert
    suspend fun insert(playground: PlaygroundEntity)

    @Query("SELECT * FROM playground")
    fun getPlayground(): Flow<PlaygroundEntity>
}