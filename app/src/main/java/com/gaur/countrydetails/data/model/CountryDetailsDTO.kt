package com.gaur.countrydetails.data.model

data class CountryDetailsDTO(
    val currency: CurrencyDTO?,
    val electricity: ElectricityDTO?,
    val language: List<LanguageDTO>?,
    val names: NamesDTO?,
    val neighbors: List<NeighborDTO>?,
    val telephone: TelephoneDTO?,
    val timezone: TimezoneDTO?,
    val vaccinations: List<VaccinationDTO>?,
    val water: WaterDTO?
)