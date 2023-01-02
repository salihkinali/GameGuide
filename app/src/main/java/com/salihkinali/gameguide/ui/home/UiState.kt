package com.salihkinali.gameguide.ui.home

import androidx.annotation.StringRes

sealed class UiState {
    object Loading : UiState()
    data class Error(@StringRes val error: Int) : UiState()
    data class Success(val data: List<TotalGameUiData>) : UiState()
}