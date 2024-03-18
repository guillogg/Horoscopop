package com.example.horoscopop.data.providers

import com.example.horoscopop.domain.model.HoroscopoInfo
import com.example.horoscopop.domain.model.HoroscopoInfo.*
import javax.inject.Inject


class HoroscopoProvider @Inject constructor() {
    fun getHoroscopo(): List<HoroscopoInfo> {
        return listOf(
            Aries,
            Tauro,
            Geminis,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Escorpio,
            Sagitario,
            Capricornio,
            Acuario,
            Picis,
        )
    }
}