package com.salihkinali.gameguide.ui.home

import android.view.ViewGroup
import com.salihkinali.gameguide.ui.base.BaseRecyclerAdapter

class HomeAdapter : BaseRecyclerAdapter<TotalGameUiData, GameViewHolder>() {
     val itemClickListener: TotalGameUiData? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder.createFrom(parent)
    }
}