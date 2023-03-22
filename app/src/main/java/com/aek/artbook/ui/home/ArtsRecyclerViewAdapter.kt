package com.aek.artbook.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.aek.artbook.databinding.ItemHomeArtRowBinding
import com.aek.artbook.domain.ArtModel
import com.aek.artbook.ui.base.BaseRecyclerViewAdapter
import com.aek.artbook.utils.extentions.loadImage

class ArtsRecyclerViewAdapter : BaseRecyclerViewAdapter<ArtModel, ItemHomeArtRowBinding>() {

    override val kClass: BaseRecyclerViewAdapter<ArtModel, ItemHomeArtRowBinding>
        get() = this

    override fun equalsItem(oldItem: ArtModel, newItem: ArtModel): Boolean =
        oldItem.id == newItem.id

    override fun getViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): ItemHomeArtRowBinding = ItemHomeArtRowBinding.inflate(inflater, parent, false)

    @SuppressLint("ResourceAsColor")
    override fun setData(binding: ItemHomeArtRowBinding, item: ArtModel, position: Int) {
        with(binding) {
            imageView.loadImage(item.imagePath)
            textViewArtName.text = item.name
            textViewArtistName.text = item.artistName
            textViewYear.text = item.year
        }
    }
}
