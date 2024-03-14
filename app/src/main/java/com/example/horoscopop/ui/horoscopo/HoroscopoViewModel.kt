package com.example.horoscopop.ui.horoscopo

import androidx.lifecycle.ViewModel
import com.example.horoscopop.data.providers.HoroscopoProvider
import com.example.horoscopop.domain.HoroscopoInfo
import com.example.horoscopop.domain.HoroscopoInfo.*

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
@HiltViewModel
class HoroscopoViewModel@Inject constructor(): ViewModel() {

    private var _horoscopo = MutableStateFlow<List<HoroscopoInfo>>(emptyList())
    val horoscopo:StateFlow<List<HoroscopoInfo>> = _horoscopo

    init{
        _horoscopo.value = HoroscopoProvider
    }

}