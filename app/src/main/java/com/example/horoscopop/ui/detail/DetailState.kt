package com.example.horoscopop.ui.detail

sealed class DetailState {
    data object Loading : DetailState()
    data class Error(val error:String) : DetailState()
    data class  Success(val data:String):DetailState()

}