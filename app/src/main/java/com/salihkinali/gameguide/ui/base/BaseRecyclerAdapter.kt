package com.salihkinali.gameguide.ui.base

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T : Any, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {

    private val games = mutableListOf<T>()

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(games[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateGames(games: MutableList<T>) {
        games.apply {
            clear()
            addAll(games)
            notifyDataSetChanged()
        }
    }
}
