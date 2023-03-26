package com.aek.artbook.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.aek.artbook.data.model.ArtModel
import com.aek.artbook.databinding.FragmentArtsBinding
import com.aek.artbook.extentions.addDivider
import com.aek.artbook.extentions.addToSwipeCallback
import com.aek.artbook.ui.base.BaseFragmentWithViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtsFragment : BaseFragmentWithViewModel<FragmentArtsBinding, ArtsViewModel>
(ArtsViewModel::class.java) {

    private val artsAdapter = ArtsRecyclerViewAdapter { art, position ->
        onFavoriteClick(art, position)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        initBinding()
    }

    private fun initBinding() {
        with(binding) {
            recyclerView.apply {
                adapter = artsAdapter
                addDivider()
                setHasFixedSize(true)
                addToSwipeCallback { position, direction ->
                    val art = artsAdapter.items[position]
                    viewModel.deleteArt(art)
                    artsAdapter.deleteItem(position)
                    Snackbar.make(this, "Article deleted successfully", Snackbar.LENGTH_LONG)
                        .apply {
                            setAction("Undo") {
                                viewModel.insertArt(art)
                                artsAdapter.insertItem(art, position)
                            }.show()
                        }
                }
            }

            fab.setOnClickListener {
                val directions = ArtsFragmentDirections.actionToArtAddFormFragment()
                it.findNavController().navigate(directions)
            }
        }
    }

    private fun observeViewModel() {
        viewModel.artsLiveData.observe(viewLifecycleOwner) {
            artsAdapter.items = it
        }
    }

    private fun onFavoriteClick(artModel: ArtModel, position: Int) {
        artModel.isFavorite = !artModel.isFavorite
        viewModel.updateArt(artModel)
        artsAdapter.updateItem(artModel, position)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getSavedArtList()
    }

    override fun getViewBinding(inflater: LayoutInflater, parent: ViewGroup?): FragmentArtsBinding {
        return FragmentArtsBinding.inflate(inflater, parent, false)
    }
}
