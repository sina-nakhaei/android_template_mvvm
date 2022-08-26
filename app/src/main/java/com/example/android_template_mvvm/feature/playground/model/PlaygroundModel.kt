package com.example.android_template_mvvm.feature.playground.model

import kotlinx.serialization.Serializable

@Serializable
data class PlaygroundModel(
    val title: String
)

fun PlaygroundModel.toEntity(): PlaygroundEntity = PlaygroundEntity(title = this.title)