package com.example.android_template_mvvm.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(
    private val repository: BaseRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) :
    ViewModel(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + dispatcher

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}