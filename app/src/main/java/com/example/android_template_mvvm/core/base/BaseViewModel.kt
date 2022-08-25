package com.example.android_template_mvvm.core.base

import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseViewModel(private val repository: BaseRepository) :
    ViewModel() {
}