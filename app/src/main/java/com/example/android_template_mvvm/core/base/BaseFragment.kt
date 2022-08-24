package com.example.android_template_mvvm.core.base


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VBinding : ViewBinding, ViewModel : BaseViewModel> : Fragment() {

    private lateinit var viewModel: ViewModel
    protected abstract fun getViewModelClass(): Class<ViewModel>

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
        configuration()
        viewsController()
        observer()
    }

    /**
     * here is the place to setup your primary configuration
     */
    open fun configuration() {}
    open fun viewsController() {}

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
        viewModel = ViewModelProvider(this)[getViewModelClass()]
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}