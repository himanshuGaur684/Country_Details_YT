package com.gaur.countrydetails.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gaur.countrydetails.presentation.country_list.CountryListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationItem.CountryListNavigationItem.route
    ) {
         composable(NavigationItem.CountryDetailsNavigationItem.route){

         }
        composable(NavigationItem.CountryListNavigationItem.route){
            CountryListScreen()
        }

    }


}