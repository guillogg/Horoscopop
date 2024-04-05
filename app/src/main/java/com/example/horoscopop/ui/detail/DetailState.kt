package com.example.horoscopop.ui.detail

import com.example.horoscopop.domain.model.HoroscopoModel

sealed class DetailState {
    data object Loading : DetailState()
    data class Error(val error:String) : DetailState()
    data class Success(val prediction:String,val sign:String, val horoscopoModel: HoroscopoModel):DetailState()

}