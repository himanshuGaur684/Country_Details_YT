package com.gaur.countrydetails.domain.model

import com.gaur.countrydetails.domain.model.Compare

data class Currency(
    val code: String,
    val compare: List<Compare>,
    val name: String,
    val rate: String,
    val symbol: Any
)