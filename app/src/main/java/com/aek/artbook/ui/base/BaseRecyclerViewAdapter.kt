package com.aek.artbook.ui.base

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerViewAdapter<T : Any, VB : ViewBinding> :
    RecyclerView.Adapter<BaseRecyclerViewAdapter.Holder<VB>>() {

    protected val diffCallback = object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    var items: List<T>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    fun insertItem(item: T, position: Int) {
        items = items.toMutableList().apply {
            this.add(position, item)
        }
        notifyItemChanged(position)
    }

    fun updateItem(item: T, position: Int) {
        items = items.toMutableList().apply {
            this[position] = item
        }
        notifyItemChanged(position)
    }

    fun deleteItem(position: Int) {
        items = items.toMutableList().apply {
            this.removeAt(position)
        }
        notifyItemRemoved(position)
    }

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder<VB> {
        val binding = getViewBinding(LayoutInflater.from(parent.context), parent)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder<VB>, position: Int) {
        setData(holder.binding, items[position], position)
    }

    protected abstract val differ: AsyncListDiffer<T>

    protected abstract fun getViewBinding(inflater: LayoutInflater, parent: ViewGroup?): VB

    protected abstract fun setData(binding: VB, item: T, position: Int)

    class Holder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)
}
