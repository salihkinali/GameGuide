package com.salihkinali.gameguide.ui.home

import android.annotation.SuppressLint
import android.view.ViewGroup
import com.salihkinali.gameguide.databinding.AdapterListItemBinding
import com.salihkinali.gameguide.ui.base.BaseViewHolder
import com.salihkinali.gameguide.utility.downloadImage
import com.salihkinali.gameguide.utility.inflateBinding

class GameViewHolder(private val binding: AdapterListItemBinding, private val itemClick: ((Int) -> Unit)?) :
    BaseViewHolder<TotalGameUiData>(binding.root) {

    companion object {
        fun createFrom(parent: ViewGroup, itemClickListener: ((Int) -> Unit)?): GameViewHolder {
            return GameViewHolder(parent.inflateBinding(AdapterListItemBinding::inflate),itemClickListener)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBind(data: TotalGameUiData) {
        binding.apply {
            gameTitle.text = data.name
            gameImage.downloadImage(data.backgroundImage)
            gameRatingText.text = "Rating: ${data.rating}"
            gameReleasedText.text = "Released: ${data.released}"
            itemBody.setOnClickListener { itemClick?.invoke(data.id) }
        }
    }

}