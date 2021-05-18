package com.example.assignmentweek3.network

import com.example.assignmentweek3.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface BeritaService {

    @GET("everything?q=olahraga&from=2021-04-18&sortBy=publishedAt&apiKey=79ecfdbf565a4bbb98bdf7c42750c1d2")
    fun getDataBerita():Call<ResponseServer>
}