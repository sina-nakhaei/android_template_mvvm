package com.example.android_template_mvvm.core.base

import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseActivityWithViewModel<VBinding : ViewBinding, ViewModel : BaseViewModel> :
    BaseActivity<VBinding>() {

    @Inject
    lateinit var viewModel: ViewModel

    /**
     * call this whenever you need to get access to your viewModel
     */
    fun viewModelController(block: ViewModel.() -> Unit = {}) {
        block(viewModel)
    }
}