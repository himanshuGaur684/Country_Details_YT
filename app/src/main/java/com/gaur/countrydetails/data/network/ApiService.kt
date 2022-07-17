package com.gaur.countrydetails.data.network

import com.gaur.countrydetails.data.model.CountryDTO
import com.gaur.countrydetails.data.model.CountryDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("countries.json")
    suspend fun getCountryList():List<CountryDTO>


    @GET("{country_name}")
    suspend fun getCountryDetails(
        @Path("country_name") countryName:String,
        @Query("format") format:String="json"
    ):CountryDetailsDTO


}