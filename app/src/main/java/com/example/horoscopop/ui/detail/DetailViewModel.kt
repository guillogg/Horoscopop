package com.example.horoscopop.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horoscopop.domain.model.HoroscopoModel
import com.example.horoscopop.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :
    ViewModel() {
    private var _state = MutableStateFlow<DetailState>(DetailState.Loading)
    val state: StateFlow<DetailState> = _state
    lateinit var horoscope: HoroscopoModel

    fun getHoroscope(sign: HoroscopoModel) {
        horoscope = sign
        viewModelScope.launch {
            _state.value = DetailState.Loading
           val result = withContext(Dispatchers.IO) { getPredictionUseCase(sign.name) } // dispatcher.io corre la funcion en hilo secundario
            if (result!=null){
                _state.value = DetailState.Success(result.horoscope,result.sign,horoscope)
                Log.i("prueba",result.horoscope)
            }else{
                _state.value = DetailState.Error("Ha ocurrido un error")
            }

        }
    }
}