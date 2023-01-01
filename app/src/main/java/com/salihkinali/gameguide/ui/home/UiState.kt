package com.salihkinali.gameguide.ui.home

sealed class UiState {
    object Loading : UiState()
    data class Error(val error: String):UiState()
    data class Success(val data: List<TotalGameUiData>):UiState()
}