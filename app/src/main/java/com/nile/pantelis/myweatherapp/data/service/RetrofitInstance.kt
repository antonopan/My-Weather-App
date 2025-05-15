package com.nile.pantelis.myweatherapp.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance{
    private const val BASE_URL ="https://api.open-meteo.com/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build() //.create()

    }
}