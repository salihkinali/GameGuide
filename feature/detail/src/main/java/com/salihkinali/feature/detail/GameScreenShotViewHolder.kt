package com.salihkinali.feature.detail

import android.view.ViewGroup
import com.salihkinali.feature.detail.databinding.AppScreenshotsItemBinding
import com.salihkinali.ui.base.BaseViewHolder
import com.salihkinali.ui.extension.downloadImage
import com.salihkinali.ui.extension.inflateBinding

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