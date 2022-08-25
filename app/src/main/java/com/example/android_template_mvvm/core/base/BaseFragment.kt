package com.example.android_template_mvvm.core.base


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseFragment<VBinding : ViewBinding, ViewModel : BaseViewModel> : Fragment() {

    @Inject
    lateinit var viewModel: ViewModel


    private var _binding: VBinding? = null
    protected val binding get() = _binding!!

    protected abstract fun getViewBinding(): VBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        primary()
        configuration()
        viewsConfiguration()
        observer()
    }

    /**
     * anything needs to be run as soon as view is created goes here
     */
    open fun primary() {}

    /**
     * here is the place to setup your primary configuration
     */
    open fun configuration() {}

    /**
     * anything you need to do with views implemented here
     */
    open fun viewsConfiguration() {}

    /**
     * observe your data here
     */
    open fun observer() {}

    /**
     * call this whenever you need to get access to your viewModel
     */
    fun viewModelController(block: ViewModel.() -> Unit = {}) {
        block(viewModel)
    }

    private fun init() {
        _binding = getViewBinding()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}