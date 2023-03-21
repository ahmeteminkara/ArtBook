package com.aek.artbook.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.aek.artbook.ui.base.BaseFragmentWithViewModel
import com.aek.artbook.databinding.FragmentArtsBinding

class ArtsFragment : BaseFragmentWithViewModel<FragmentArtsBinding, ArtsViewModel>(
    ArtsViewModel::class.java
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            val directions = ArtsFragmentDirections.actionArtsFragmentToArtAddFormFragment()
            it.findNavController().navigate(directions)
        }
    }

    override fun getViewBinding(inflater: LayoutInflater, parent: ViewGroup?): FragmentArtsBinding {
        return FragmentArtsBinding.inflate(inflater, parent, false)
    }
}
