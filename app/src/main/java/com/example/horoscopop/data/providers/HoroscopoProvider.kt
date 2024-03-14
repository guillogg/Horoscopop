package com.example.horoscopop.data.providers

import com.example.horoscopop.domain.HoroscopoInfo
import com.example.horoscopop.domain.HoroscopoInfo.*

class HoroscopoProvider {
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