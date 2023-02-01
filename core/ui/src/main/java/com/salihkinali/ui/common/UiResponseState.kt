package com.salihkinali.ui.common

import androidx.annotation.StringRes

sealed class UiResponseState<out T: Any> {
    object Loading : UiResponseState<Nothing>()
    data class Error(@StringRes val error: Int) : UiResponseState<Nothing>()
    data class Success<out T: Any>(val data:T) : UiResponseState<T>()
}