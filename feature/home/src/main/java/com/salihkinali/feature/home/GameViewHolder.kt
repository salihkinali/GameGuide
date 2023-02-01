package com.salihkinali.feature.home

import android.annotation.SuppressLint
import android.view.ViewGroup
import com.salihkinali.feature.home.databinding.AdapterListItemBinding
import com.salihkinali.ui.base.BaseViewHolder
import com.salihkinali.ui.extension.downloadImage
import com.salihkinali.ui.extension.inflateBinding

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