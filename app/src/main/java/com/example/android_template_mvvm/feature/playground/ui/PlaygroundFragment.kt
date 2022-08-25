package com.example.android_template_mvvm.feature.playground.ui

import com.example.android_template_mvvm.core.base.BaseFragment
import com.example.android_template_mvvm.core.base.BaseFragmentWithViewModel
import com.example.android_template_mvvm.databinding.FragmentPlaygroundBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_playground.*

/**
 * here is your handy fragment where you can quickly test
 * and build up your new features before implementing them in the real classes
 * don't forget to change navGraph in [activity_main]
 */
@AndroidEntryPoint
class PlaygroundFragment :
    BaseFragmentWithViewModel<FragmentPlaygroundBinding, PlaygroundViewModel>() {

    companion object {
        fun newInstance() = PlaygroundFragment()
    }


    override fun getViewBinding(): FragmentPlaygroundBinding =
        FragmentPlaygroundBinding.inflate(layoutInflater)

    override fun primary() {
        viewModelController {
            fetch()

        }
    }

    override fun viewsConfiguration() {
        tvName.text = "heyyyyyyyy"
    }

    override fun observer() {
        viewModelController {
            post.observe(viewLifecycleOwner) {
                tvName.text = it.title
            }
        }
    }
}