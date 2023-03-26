package com.aek.artbook.extentions

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.addDivider() {
    if (this.layoutManager !is LinearLayoutManager) return
    val layoutManager = this.layoutManager as LinearLayoutManager
    val divider = DividerItemDecoration(this.context, layoutManager.orientation)
    this.addItemDecoration(divider)
}

fun RecyclerView.addToSwipeCallback(
    onMoveEnabled: Boolean = true,
    swipeDirs: Int = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT,
    onSwipedWithReturnUndo: (position: Int, direction: Int) -> Unit
) {
    val callback = object : ItemTouchHelper.SimpleCallback(0, swipeDirs) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun isItemViewSwipeEnabled(): Boolean {
            return onMoveEnabled
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            onSwipedWithReturnUndo.invoke(viewHolder.layoutPosition, direction)
        }
    }
    ItemTouchHelper(callback).attachToRecyclerView(this)
}
