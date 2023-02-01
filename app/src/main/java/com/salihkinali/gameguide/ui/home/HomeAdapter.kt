package com.salihkinali.gameguide.ui.home

import android.view.ViewGroup
import com.salihkinali.ui.base.BaseRecyclerAdapter

class HomeAdapter(private val itemClickListener: ((Int) -> Unit)?) : BaseRecyclerAdapter<TotalGameUiData, GameViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder.createFrom(parent,itemClickListener)
    }
}