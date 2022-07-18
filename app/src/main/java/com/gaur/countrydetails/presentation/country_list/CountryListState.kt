package com.gaur.countrydetails.presentation.country_list

import com.gaur.countrydetails.domain.model.Country

data class CountryListState(
    val isLoading:Boolean=false,
    val error:String="",
    val data:List<Country>?=null
)
