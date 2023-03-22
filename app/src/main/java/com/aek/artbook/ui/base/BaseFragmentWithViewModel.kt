package com.aek.artbook.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseFragmentWithViewModel<VB : ViewBinding, VM : BaseViewModel>(
    private val viewModelClass: Class<VM>
) : BaseFragment() {

    protected lateinit var binding: VB
    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[viewModelClass]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeBaseViewModel()
    }

    private fun observeBaseViewModel() {
        with(viewModel) {
            loadingLiveData.observe(viewLifecycleOwner) {
            }

            errorLiveData.observe(viewLifecycleOwner) { errorModel ->
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        viewModel.loadingLiveData.removeObservers(viewLifecycleOwner)
        viewModel.errorLiveData.removeObservers(viewLifecycleOwner)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding(inflater, container)
        return binding.root
    }

    protected abstract fun getViewBinding(inflater: LayoutInflater, parent: ViewGroup?): VB
}
