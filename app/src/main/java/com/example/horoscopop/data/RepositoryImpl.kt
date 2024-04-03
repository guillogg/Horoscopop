package com.example.horoscopop.data

import android.util.Log
import com.example.horoscopop.data.network.HoroscopoApiService
import com.example.horoscopop.domain.Repository
import com.example.horoscopop.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopoApiService):Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
       runCatching { apiService.getHoroscope(sign) }
           .onSuccess { return it.toDomain() }
           .onFailure { Log.i("error","ocurrio un error${it.message}") }

        return null
    }
}