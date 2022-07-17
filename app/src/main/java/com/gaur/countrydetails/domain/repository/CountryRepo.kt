package com.gaur.countrydetails.domain.repository

import com.gaur.countrydetails.domain.model.Country
import com.gaur.countrydetails.domain.model.CountryDetails

interface CountryRepo {

    suspend fun getCountryList():List<Country>
    suspend fun getCountryDetails(countryName:String):CountryDetails

}