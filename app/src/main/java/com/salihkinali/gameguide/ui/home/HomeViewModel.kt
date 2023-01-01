package com.salihkinali.gameguide.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salihkinali.gameguide.domain.entity.TotalGameEntity
import com.salihkinali.gameguide.domain.mapper.GameListMapper
import com.salihkinali.gameguide.domain.usecase.GetTotalGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val gameUseCase: GetTotalGameUseCase,
    private val gameListMapper: GameListMapper<TotalGameEntity, TotalGameUiData>
) : ViewModel() {

    private val _homeUiData = MutableLiveData<UiState>()
    val homeUidata: LiveData<UiState> get() = _homeUiData

    //Burada Kaldım buradan devam edeceğim.
    fun getData(){
        viewModelScope.launch {
            gameUseCase
        }
    }
}