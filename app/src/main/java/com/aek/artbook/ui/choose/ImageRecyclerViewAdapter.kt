package com.aek.artbook.ui.choose

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aek.artbook.data.model.Image
import com.aek.artbook.databinding.ItemSearchImageGridRowBinding
import com.aek.artbook.ui.base.BaseRecyclerViewAdapter
import com.aek.artbook.utils.extentions.ignoreNull
import com.aek.artbook.utils.extentions.loadImage

class ImageRecyclerViewAdapter(
    private val onSelectImage: (Image) -> Unit
) : BaseRecyclerViewAdapter<Image, ItemSearchImageGridRowBinding>() {

    override fun equalsItemOfModel(oldItem: Image, newItem: Image): Boolean =
        oldItem.id == newItem.id

    override fun getViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): ItemSearchImageGridRowBinding =
        ItemSearchImageGridRowBinding.inflate(inflater, parent, false)

    override fun setData(binding: ItemSearchImageGridRowBinding, item: Image, position: Int) {
        with(binding.imageView) {
            loadImage(item.previewURL.ignoreNull())
            setOnClickListener { onSelectImage.invoke(item) }
        }
    }
}
