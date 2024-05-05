package com.turk.universityreposiotry

import com.turk.dtos.model.UniversityEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityApiService {

    @GET("/search")
    suspend fun getUniversities(@Query("country") country:String): List<UniversityEntity>

}