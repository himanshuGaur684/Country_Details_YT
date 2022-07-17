package com.gaur.countrydetails.data.model

import com.gaur.countrydetails.data.model.CompareDTO

data class CurrencyDTO(
    val code: String?,
    val compare: List<CompareDTO>?,
    val name: String?,
    val rate: String?,
    val symbol: String?
)