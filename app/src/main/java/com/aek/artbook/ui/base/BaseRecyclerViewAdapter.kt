package com.aek.artbook.ui.base

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerViewAdapter<T : Any, VB : ViewBinding> :
    RecyclerView.Adapter<BaseRecyclerViewAdapter.Holder>() {

    private val listDiffer by lazy {
        AsyncListDiffer(
            this,
            object : DiffUtil.ItemCallback<T>() {
                override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
                    oldItem == newItem

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
                    oldItem == newItem
            }
        )
    }

    fun getItem(position: Int): T {
        return listDiffer.currentList[position]
    }

    fun getItems(): List<T> = listDiffer.currentList

    fun updateList(newList: List<T>) {
        listDiffer.submitList(newList)
    }

    fun refreshList() {
        listDiffer.submitList(listDiffer.currentList)
    }

    fun deleteItem(position: Int) {
        val newList = ArrayList<T>(listDiffer.currentList)
        newList.removeAt(position)
        updateList(newList)
    }

    fun clear() {
        updateList(listOf())
    }

    fun notifyItem(position: Int) {
        notifyItemChanged(position)
    }

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = getViewBinding(LayoutInflater.from(parent.context), parent)
        return Holder(binding)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        setData(holder.viewBinding as VB, listDiffer.currentList[position], position)
    }

    override fun getItemCount() = listDiffer.currentList.size

    protected abstract fun getViewBinding(inflater: LayoutInflater, parent: ViewGroup?): VB

    protected abstract fun setData(binding: VB, item: T, position: Int)

    protected abstract fun equalsItemOfModel(oldItem: T, newItem: T): Boolean

    class Holder(val viewBinding: ViewBinding) : RecyclerView.ViewHolder(viewBinding.root)
}
