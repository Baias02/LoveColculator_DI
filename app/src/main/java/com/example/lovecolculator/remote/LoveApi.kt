package com.example.lovecolculator.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun getPercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "c925af2796mshb82fc88b2420a27p17a961jsncc2cc23edde1",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com",
    ): Call<LoveModel>
}