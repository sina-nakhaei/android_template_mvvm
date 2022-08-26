package com.example.android_template_mvvm.feature.playground.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playground")
data class PlaygroundEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "title") val title: String,
)

fun PlaygroundEntity.toModel() = PlaygroundModel(title = title)