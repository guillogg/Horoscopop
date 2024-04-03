package com.example.horoscopop.data.network

import com.example.horoscopop.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopoApiService {
    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign:String):PredictionResponse

}