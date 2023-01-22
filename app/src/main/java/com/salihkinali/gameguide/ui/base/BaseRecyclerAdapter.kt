package com.salihkinali.gameguide.ui.base

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T : Any, VH : BaseViewHolder<T>> :
    RecyclerView.Adapter<VH>() {

    private val items = mutableListOf<T>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems: List<T>) {
        items.apply {
            clear()
            addAll(newItems)
            notifyDataSetChanged()
        }
    }

    fun getItem(position: Int) = items[position]

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount() = items.size
}
