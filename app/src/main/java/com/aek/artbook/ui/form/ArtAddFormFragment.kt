package com.aek.artbook.ui.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.aek.artbook.databinding.FragmentArtAddFormBinding
import com.aek.artbook.ui.base.BaseFragmentWithViewModel
import com.aek.artbook.constants.AppConstants
import com.aek.artbook.extentions.getNavigationResult
import com.aek.artbook.extentions.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtAddFormFragment :
    BaseFragmentWithViewModel<FragmentArtAddFormBinding, ArtAddFormViewModel>(
        ArtAddFormViewModel::class.java
    ) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinding()
        initFragmentResult()
        observeViewModel()
    }

    private fun initBinding() {
        with(binding) {
            imageViewChoose.setOnClickListener {
                val action = ArtAddFormFragmentDirections.actionToImageChooseFragment()
                it.findNavController().navigate(action)
            }
            buttonSave.setOnClickListener {
                val name = editTextArtName.text?.trim().toString()
                val artistName = editTextArtistName.text?.trim().toString()
                val year = editTextYear.text?.trim().toString()
                viewModel.insertArt(name, artistName, year)
            }
        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            insertLiveData.observe(viewLifecycleOwner) {
                binding.root.findNavController().popBackStack()
            }
        }
    }

    private fun initFragmentResult() {
        this.getNavigationResult<String>(AppConstants.NavigationResult.SELECT_IMAGE)
            ?.observe(viewLifecycleOwner) { imagePath ->
                if (imagePath.isNotEmpty()) {
                    viewModel.setSelectedImagePath(imagePath)
                    binding.imageViewChoose.loadImage(imagePath)
                }
            }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentArtAddFormBinding = FragmentArtAddFormBinding.inflate(inflater, parent, false)
}
