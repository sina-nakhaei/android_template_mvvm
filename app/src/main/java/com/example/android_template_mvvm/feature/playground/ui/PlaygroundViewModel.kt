package com.example.android_template_mvvm.feature.playground.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_template_mvvm.core.base.BaseViewModel
import com.example.android_template_mvvm.feature.playground.model.PlaygroundModel
import com.example.android_template_mvvm.feature.playground.repository.PlaygroundRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlaygroundViewModel @Inject constructor(private val repository: PlaygroundRepository) :
    BaseViewModel(repository) {

    private var _post = MutableLiveData<PlaygroundModel>()
    val post: LiveData<PlaygroundModel>
        get() = _post

    fun fetch() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetch()
                .collect { playground ->
                    _post.postValue(playground)
                }
        }
    }
}