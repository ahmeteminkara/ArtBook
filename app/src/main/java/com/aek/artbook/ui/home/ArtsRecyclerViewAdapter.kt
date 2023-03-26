package com.aek.artbook.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import com.aek.artbook.R
import com.aek.artbook.data.model.ArtModel
import com.aek.artbook.databinding.ItemHomeArtRowBinding
import com.aek.artbook.extentions.ignoreNull
import com.aek.artbook.extentions.loadImage
import com.aek.artbook.ui.base.BaseRecyclerViewAdapter

class ArtsRecyclerViewAdapter(
    private val onFavoriteClick: (art: ArtModel, position: Int) -> Unit
) : BaseRecyclerViewAdapter<ArtModel, ItemHomeArtRowBinding>() {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun getViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): ItemHomeArtRowBinding = ItemHomeArtRowBinding.inflate(inflater, parent, false)

    @SuppressLint("ResourceAsColor")
    override fun setData(binding: ItemHomeArtRowBinding, item: ArtModel, position: Int) {
        binding.apply {
            imageView.loadImage(item.imagePath)
            textViewArtName.text = item.name
            textViewArtistName.text = item.artistName
            textViewYear.text = item.year
            imageViewFavorite.apply {
                setImageResource(
                    if (item.isFavorite.ignoreNull()) R.drawable.ic_favorite
                    else R.drawable.ic_unfavorite
                )
                setOnClickListener {
                    onFavoriteClick.invoke(item, position)
                }
            }
        }
    }
}
