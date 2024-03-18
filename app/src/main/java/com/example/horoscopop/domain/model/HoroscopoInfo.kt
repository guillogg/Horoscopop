package com.example.horoscopop.domain.model

import com.example.horoscopop.R

//para cantidad de objetos fijo sirve mas el sealed, para lo demas data class
sealed class HoroscopoInfo (val img:Int,val name:Int){
    object Aries: HoroscopoInfo(R.drawable.aries,R.string.Aries)
    object Tauro: HoroscopoInfo(R.drawable.tauro,R.string.Tauro)
    object Geminis: HoroscopoInfo(R.drawable.geminis,R.string.Geminis)
    object Cancer: HoroscopoInfo(R.drawable.cancer,R.string.Cancer)
    object Leo: HoroscopoInfo(R.drawable.leo,R.string.Leo)
    object Virgo: HoroscopoInfo(R.drawable.virgo,R.string.Virgo)
    object Libra: HoroscopoInfo(R.drawable.libra,R.string.Libra)
    object Escorpio: HoroscopoInfo(R.drawable.escorpio,R.string.Escorpio)
    object Sagitario: HoroscopoInfo(R.drawable.sagitario,R.string.Sagitario)
    object Capricornio: HoroscopoInfo(R.drawable.capricornio,R.string.Capricornio)
    object Acuario: HoroscopoInfo(R.drawable.aquario,R.string.Acuario)
    object Picis: HoroscopoInfo(R.drawable.piscis,R.string.Picis)
}