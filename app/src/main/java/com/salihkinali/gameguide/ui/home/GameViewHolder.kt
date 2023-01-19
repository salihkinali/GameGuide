package com.salihkinali.gameguide.ui.home

import android.view.ViewGroup
import com.salihkinali.gameguide.databinding.AdapterListItemBinding
import com.salihkinali.gameguide.ui.base.BaseViewHolder
import com.salihkinali.gameguide.utility.downloadImage
import com.salihkinali.gameguide.utility.inflateBinding

class GameViewHolder(private val binding: AdapterListItemBinding) :
    BaseViewHolder<TotalGameUiData>(binding.root) {

    companion object {
        fun createFrom(parent: ViewGroup): GameViewHolder {
            return GameViewHolder(parent.inflateBinding(AdapterListItemBinding::inflate))
        }
    }

    override fun bind(data: TotalGameUiData) {
        binding.apply {
            gameTitle.text = data.name
            gameImage.downloadImage(data.backgroundImage)
        }
    }
}