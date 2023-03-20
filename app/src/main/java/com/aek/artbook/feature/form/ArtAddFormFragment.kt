package com.aek.artbook.feature.form

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aek.artbook.core.base.BaseFragmentWithViewModel
import com.aek.artbook.databinding.FragmentArtAddFormBinding

class ArtAddFormFragment :
    BaseFragmentWithViewModel<FragmentArtAddFormBinding, ArtAddFormViewModel>(
        ArtAddFormViewModel::class.java
    ) {

    override fun getViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentArtAddFormBinding = FragmentArtAddFormBinding.inflate(inflater, parent, false)
}
