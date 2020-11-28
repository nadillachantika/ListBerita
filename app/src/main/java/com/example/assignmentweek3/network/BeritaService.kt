package com.example.assignmentweek3.network

import com.example.assignmentweek3.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface BeritaService {

    @GET("everything?q=olahraga&from=2020-05-19&sortBy=publishedAt&apiKey=0949b8f230804199943c7526b50e7b95")
    fun getDataBerita():Call<ResponseServer>
}