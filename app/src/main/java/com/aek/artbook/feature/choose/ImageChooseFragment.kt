package com.aek.artbook.feature.choose

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aek.artbook.core.base.BaseFragmentWithViewModel
import com.aek.artbook.databinding.FragmentImageChooseBinding

class ImageChooseFragment :
    BaseFragmentWithViewModel<FragmentImageChooseBinding, ImageChooseViewModel>
    (ImageChooseViewModel::class.java) {
    override fun getViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentImageChooseBinding = FragmentImageChooseBinding.inflate(inflater, parent, false)
}
