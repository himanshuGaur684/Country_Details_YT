package com.gaur.countrydetails.presentation.navigation

sealed class NavigationItem(val route:String){
    object CountryListNavigationItem : NavigationItem("country_list")
    object CountryDetailsNavigationItem : NavigationItem(route= "country_details/{country_name}")
}
