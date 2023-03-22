package com.aek.artbook.ui.choose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aek.artbook.databinding.FragmentImageChooseBinding
import com.aek.artbook.ui.base.BaseFragmentWithViewModel
import com.aek.artbook.utils.const.AppConstants
import com.aek.artbook.utils.extentions.addTextChangedListenerWithTimeout
import com.aek.artbook.utils.extentions.setNavigationResultToBack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageChooseFragment :
    BaseFragmentWithViewModel<FragmentImageChooseBinding, ImageChooseViewModel>
    (ImageChooseViewModel::class.java) {

    private val adapter = ImageRecyclerViewAdapter { selectedImage ->
        this.setNavigationResultToBack(
            AppConstants.NavigationResult.SELECT_IMAGE,
            selectedImage.largeImageURL
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        initBinding()
    }

    private fun initBinding() {
        with(binding) {
            recyclerViewSearchResult.adapter = adapter

            editTextQuery.addTextChangedListenerWithTimeout(
                AppConstants.Timeout.SEARCH_CHANGE_LISTENER_TIMEOUT_MS
            ) { query ->
                viewModel.searchQuery(query)
            }
        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            searchLiveData.observe(viewLifecycleOwner) {
                adapter.updateList(it.hits)
            }
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentImageChooseBinding = FragmentImageChooseBinding.inflate(inflater, parent, false)
}
