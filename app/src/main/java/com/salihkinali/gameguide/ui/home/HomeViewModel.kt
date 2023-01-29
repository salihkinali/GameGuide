package com.salihkinali.gameguide.ui.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salihkinali.gameguide.R
import com.salihkinali.gameguide.data.NetworkResponse
import com.salihkinali.gameguide.data.mapper.GameListMapper
import com.salihkinali.gameguide.domain.entity.TotalGameEntity
import com.salihkinali.gameguide.domain.usecase.GetTotalGameUseCase
import com.salihkinali.gameguide.ui.common.UiResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val gameUseCase: GetTotalGameUseCase,
    private val gameListMapper: GameListMapper<TotalGameEntity, TotalGameUiData>
) : ViewModel() {

    private val _homeUiData = MutableStateFlow<UiResponseState<List<TotalGameUiData>>>(UiResponseState.Loading)
    val homeUidata = _homeUiData.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            gameUseCase.invoke().collectLatest {
                when (it) {
                    is NetworkResponse.Error -> {
                        _homeUiData.emit(UiResponseState.Error(R.string.error_message))
                    }
                    is NetworkResponse.Loading -> _homeUiData.emit(UiResponseState.Loading)

                    is NetworkResponse.Success -> {
                        _homeUiData.emit(UiResponseState.Success(gameListMapper.map(it.result)))
                    }
                }
            }
        }
    }
}