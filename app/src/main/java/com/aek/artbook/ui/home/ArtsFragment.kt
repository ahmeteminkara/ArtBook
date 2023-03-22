package com.aek.artbook.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.aek.artbook.R
import com.aek.artbook.databinding.FragmentArtsBinding
import com.aek.artbook.ui.base.BaseFragmentWithViewModel
import com.aek.artbook.utils.extentions.addDivider
import com.aek.artbook.utils.extentions.addToSwipeCallback
import com.aek.artbook.views.AppAlertDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtsFragment : BaseFragmentWithViewModel<FragmentArtsBinding, ArtsViewModel>
(ArtsViewModel::class.java) {

    private val adapter = ArtsRecyclerViewAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        initBinding()
    }

    private fun initBinding() {
        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.addDivider()
            recyclerView.addToSwipeCallback { position, direction ->
                AppAlertDialog(requireContext())
                    .setTitle(R.string.confirm)
                    .setMessage(R.string.confirm_delete_data)
                    .setNegativeButton(R.string.no) {
                        adapter.notifyItem(position)
                    }
                    .setPositiveButton(R.string.yes) {
                        viewModel.deleteArt(adapter.getItem(position))
                    }
                    .show()
            }

            fab.setOnClickListener {
                val directions = ArtsFragmentDirections.actionToArtAddFormFragment()
                it.findNavController().navigate(directions)
            }
        }
    }

    private fun observeViewModel() {
        viewModel.artsLiveData.observe(viewLifecycleOwner) {
            adapter.updateList(it)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getSavedArtList()
    }

    override fun getViewBinding(inflater: LayoutInflater, parent: ViewGroup?): FragmentArtsBinding {
        return FragmentArtsBinding.inflate(inflater, parent, false)
    }
}
