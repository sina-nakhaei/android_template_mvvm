package com.example.android_template_mvvm.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseActivity<VBinding : ViewBinding> :
    AppCompatActivity() {
    
    private var _binding: VBinding? = null
    protected val binding get() = _binding!!

    abstract fun getViewBinding(): VBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setContentView(binding.root)

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

    private fun init() {
        _binding = getViewBinding()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}