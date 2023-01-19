package com.salihkinali.gameguide.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salihkinali.gameguide.data.NetworkResponse
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

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            gameUseCase.invoke().collect() {
                when (it) {
                    is NetworkResponse.Error -> {
                        Log.e("hata mesajı ", it.exception.toString())
                        //_homeUiData.postValue(UiState.Error(R.string.error_message))
                    }
                    is NetworkResponse.Loading -> (UiState.Loading)

                    is NetworkResponse.Success -> {
                        _homeUiData.postValue(UiState.Success(gameListMapper.map(it.result)))
                    }
                }
            }
        }
    }
}