package com.aek.artbook.ui.choose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aek.artbook.databinding.FragmentImageChooseBinding
import com.aek.artbook.ui.base.BaseFragmentWithViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageChooseFragment :
    BaseFragmentWithViewModel<FragmentImageChooseBinding, ImageChooseViewModel>
    (ImageChooseViewModel::class.java) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            searchLiveData.observe(viewLifecycleOwner) {
                println("response: $it")
            }
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentImageChooseBinding = FragmentImageChooseBinding.inflate(inflater, parent, false)
}
