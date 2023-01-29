package com.salihkinali.gameguide.ui.detail

import android.view.ViewGroup
import com.salihkinali.gameguide.ui.base.BaseRecyclerAdapter

class DetailScreenShotAdapter:
    BaseRecyclerAdapter<GameScreenShotUiData, GameScreenShotViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameScreenShotViewHolder {
        return GameScreenShotViewHolder.createFrom(parent)
    }
}