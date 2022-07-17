package com.gaur.countrydetails.common

import com.gaur.countrydetails.data.model.*
import com.gaur.countrydetails.domain.model.*


fun CountryDetailsDTO.toDomain():CountryDetails{
    return  CountryDetails(
        currency = currency?.toDomain()?: Currency("", emptyList(),"","",""),
        electricity = electricity?.toDomain()?: Electricity("",""),
        language = language?.map { it.toDomain() }?: emptyList(),
        names=names?.toDomain()?:Names("","","","",""),
        neighbors = neighbors?.map { it.toDomain() }?: emptyList(),
        telephone = telephone?.toDomain()?: Telephone("","","",""),
        timezone = timezone?.toDomain()?:Timezone(""),
        vaccinations = vaccinations?.map { it.toDomain() }?: emptyList(),
        water=water?.toDomain()?:Water("",""),
    )
}


fun CountryDTO.toDomain():Country{
    return Country(
        name=name?:"",
        url=url?:""
    )
}


fun CurrencyDTO.toDomain():Currency{
    return Currency(
        code = code?:"",
        compare = compare?.map { it.toDomain() }?: emptyList(),
        name=name?:"",
        rate=rate?:"",
        symbol = symbol?:""
    )
}

fun CompareDTO.toDomain():Compare{
    return Compare(
        name = name?:"",
        rate=rate?:""
    )
}

fun ElectricityDTO.toDomain():Electricity{
    return Electricity(
        frequency = frequency?:"",
        voltage = voltage?:""
    )
}

fun LanguageDTO.toDomain():Language{
    return Language(
        language = language?:"",
        official = official?:""
    )
}
fun NamesDTO.toDomain():Names{
    return Names(
        continent = continent?:"",
        full = full?:"",
        iso2 = iso2?:"",
        iso3=iso3?:"",
        name=name?:""
    )
}

fun NeighborDTO.toDomain(): Neighbor {
    return Neighbor(
        id=id?:"",
        name=name?:""
    )
}

fun TelephoneDTO.toDomain(): Telephone {
    return Telephone(ambulance = ambulance?:"",
        calling_code = calling_code?:"",
        fire = fire?:"",
        police=police ?:"")
}

fun TimezoneDTO.toDomain(): Timezone {
    return Timezone(
        name=name?:""
    )
}

fun VaccinationDTO.toDomain(): Vaccination {
    return Vaccination(
        message = message?:"",
        name=name?:"",
    )
}

fun WaterDTO.toDomain(): Water {
    return Water(
        full=full?:"",
        short = short?:""
    )
}