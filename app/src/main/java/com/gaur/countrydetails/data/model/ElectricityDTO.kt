package com.gaur.countrydetails.data.model

data class ElectricityDTO(
    val frequency: String?=null,
    val plugs: List<String>?=null,
    val voltage: String?=null
)