package com.salihkinali.gameguide.utility

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

inline fun <T : ViewBinding> ViewGroup.inflateBinding(
    crossinline bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T
) = bindingInflater(LayoutInflater.from(this.context), this, false)