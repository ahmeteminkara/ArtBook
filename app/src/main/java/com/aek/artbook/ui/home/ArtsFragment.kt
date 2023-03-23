package com.aek.artbook.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aek.artbook.R
import com.aek.artbook.data.model.ArtModel
import com.aek.artbook.databinding.FragmentArtsBinding
import com.aek.artbook.ui.base.BaseFragmentWithViewModel
import com.aek.artbook.utils.extentions.addDivider
import com.aek.artbook.utils.extentions.addToSwipeCallback
import com.aek.artbook.views.AppAlertDialog
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

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
                // val directions = ArtsFragmentDirections.actionToArtAddFormFragment()
                // it.findNavController().navigate(directions)

                val list = adapter.getItems().toMutableList()
                list[0].name = Calendar.getInstance().time.toString()
                list[0].imagePath = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"

                adapter.updateList(list)
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
