package com.salihkinali.gameguide.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salihkinali.gameguide.R
import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.data.mapper.GameListMapper
import com.salihkinali.gameguide.data.mapper.GameMapper
import com.salihkinali.gameguide.domain.entity.GameScreenShotEntity
import com.salihkinali.gameguide.domain.entity.SingleGameEntity
import com.salihkinali.gameguide.domain.usecase.GetGameScreenShotUseCase
import com.salihkinali.gameguide.domain.usecase.GetSingleGameUseCase
import com.salihkinali.gameguide.ui.common.UiResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val singleGameUseCase: GetSingleGameUseCase,
    private val gameScreenShotUseCase: GetGameScreenShotUseCase,
    private val gameScreenShotUiMapper: GameListMapper<GameScreenShotEntity, GameScreenShotUiData>,
    private val singleGameMapper: GameMapper<SingleGameEntity, SingleGameUiData>
) : ViewModel() {

    private val _detailUiData =
        MutableStateFlow<UiResponseState<SingleGameUiData>>(UiResponseState.Loading)
    val detailUiData: StateFlow<UiResponseState<SingleGameUiData>> get() = _detailUiData

    private val _detailScreenShot =
        MutableStateFlow<UiResponseState<List<GameScreenShotUiData>>>(UiResponseState.Loading)
    val detailScreenShot = _detailScreenShot.asStateFlow()




    fun getDataFromSource(id: Int) {
        viewModelScope.launch {

            singleGameUseCase.invoke(id).collectLatest {

                when (it) {
                    is NetworkResponse.Error -> {
                        _detailUiData.emit(UiResponseState.Error(R.string.error_message))
                    }
                    is NetworkResponse.Loading -> _detailUiData.emit(UiResponseState.Loading)

                    is NetworkResponse.Success -> {
                        _detailUiData.emit(UiResponseState.Success(singleGameMapper.map(it.result)))
                    }
                }
            }

            gameScreenShotUseCase.invoke(id).collectLatest {
                when (it) {

                    is NetworkResponse.Error -> {
                        _detailScreenShot.emit(UiResponseState.Error(R.string.error_message))
                    }
                    is NetworkResponse.Loading -> _detailScreenShot.emit(UiResponseState.Loading)

                    is NetworkResponse.Success -> {
                        _detailScreenShot.emit(UiResponseState.Success(gameMapper(it.result)))
                    }
                }
            }
        }
    }

    private fun gameMapper(list: List<GameScreenShotEntity>): List<GameScreenShotUiData> {
        return gameScreenShotUiMapper.map(list)
    }
}

