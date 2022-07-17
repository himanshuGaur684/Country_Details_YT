package com.gaur.countrydetails.data.repository

import com.gaur.countrydetails.common.toDomain
import com.gaur.countrydetails.data.network.ApiService
import com.gaur.countrydetails.domain.model.Country
import com.gaur.countrydetails.domain.model.CountryDetails
import com.gaur.countrydetails.domain.repository.CountryRepo

class CountryRepoImpl(private val apiService: ApiService) : CountryRepo {

    override suspend fun getCountryList(): List<Country> {
        return apiService.getCountryList().map { it.toDomain() }
    }

    override suspend fun getCountryDetails(countryName: String): CountryDetails {
         return apiService.getCountryDetails(countryName = countryName).toDomain()
    }
}