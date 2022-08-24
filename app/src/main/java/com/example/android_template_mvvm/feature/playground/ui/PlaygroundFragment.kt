package com.example.android_template_mvvm.feature.playground.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import com.example.android_template_mvvm.R
import com.example.android_template_mvvm.core.base.BaseFragment
import com.example.android_template_mvvm.core.base.BaseViewModel
import com.example.android_template_mvvm.databinding.FragmentPlaygroundBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * here is your handy fragment where you can quickly test
 * and build up your new features before implementing them in the real classes
 * don't forget to change navGraph in [activity_main]
 */
@AndroidEntryPoint
class PlaygroundFragment : BaseFragment<FragmentPlaygroundBinding, PlaygroundViewModel>() {

    companion object {
        fun newInstance() = PlaygroundFragment()
    }

    override fun getViewModelClass(): Class<PlaygroundViewModel> = PlaygroundViewModel::class.java

    override fun getViewBinding(): FragmentPlaygroundBinding =
        FragmentPlaygroundBinding.inflate(layoutInflater)

    override fun viewsController() {
        super.viewsController()
        binding.apply {
            tvName.text = "Hey Sina"
        }
    }

    override fun observer() {
        viewModelController {
            test()
        }
    }
}