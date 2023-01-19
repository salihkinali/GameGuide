package com.salihkinali.gameguide.utility

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.downloadImage(url: String?) {
    Glide.with(this)
        .load(url)
        .into(this)
}

fun View.visible(visible: Boolean) {
    if (visible) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}
