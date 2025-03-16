package com.example.tutorbookingsystem

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface TutorApiService {
    @GET("tutors")
    suspend fun getTutors(@Query("subject") subject: String?): List<Tutor>
}

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.tutorbooking.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: TutorApiService = retrofit.create(TutorApiService::class.java)
}
