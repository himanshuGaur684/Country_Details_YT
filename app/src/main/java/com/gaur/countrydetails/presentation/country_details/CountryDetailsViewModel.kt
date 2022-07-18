package com.gaur.countrydetails.presentation.country_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaur.countrydetails.common.Resource
import com.gaur.countrydetails.domain.use_cases.GetCountryDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryDetailsViewModel @Inject constructor(
    private val getCountryDetailsUseCase: GetCountryDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {



    private val _countryDetails = mutableStateOf(CountryDetailsState())
    val countryDetails : State<CountryDetailsState> = _countryDetails


    fun getCountryDetails(countryName:String){
        getCountryDetailsUseCase(countryName = countryName).onEach {
            when(it){

                is Resource.Loading ->{
                    _countryDetails.value = CountryDetailsState(isLoading = true)
                }
                is Resource.Error ->{
                    _countryDetails.value = CountryDetailsState(error =it.message.toString())
                }
                is Resource.Success ->{
                    _countryDetails.value = CountryDetailsState(data = it.data)
                }

            }
        }.launchIn(viewModelScope)
    }


}