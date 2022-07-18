package com.gaur.countrydetails.presentation.country_details

import com.gaur.countrydetails.domain.model.CountryDetails

data class CountryDetailsState(
    val isLoading:Boolean=false,
    val error:String="",
    val data:CountryDetails?=null
)
