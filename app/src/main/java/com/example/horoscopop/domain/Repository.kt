package com.example.horoscopop.domain


import com.example.horoscopop.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}