package com.salihkinali.gameguide.ui.detail

import android.view.ViewGroup
import com.salihkinali.gameguide.databinding.AppScreenshotsItemBinding
import com.salihkinali.gameguide.ui.base.BaseViewHolder
import com.salihkinali.gameguide.utility.downloadImage
import com.salihkinali.gameguide.utility.inflateBinding

class GameScreenShotViewHolder(private val binding: AppScreenshotsItemBinding) :
    BaseViewHolder<GameScreenShotUiData>(binding.root) {

    companion object {
        fun createFrom(parent: ViewGroup): GameScreenShotViewHolder {
            return GameScreenShotViewHolder(parent.inflateBinding(AppScreenshotsItemBinding::inflate))
        }
    }

    override fun onBind(data: GameScreenShotUiData) {
        binding.screenShotImage.downloadImage(data.gameShotData)
    }
}