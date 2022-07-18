package com.gaur.countrydetails.presentation.country_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaur.countrydetails.common.Resource
import com.gaur.countrydetails.domain.use_cases.GetCountryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(private val getCountryListUseCase: GetCountryListUseCase) :
    ViewModel() {


    init {
        getCountryList()
    }

        private val _list = mutableStateOf(CountryListState())
        val list: State<CountryListState> = _list

        fun getCountryList(){
            getCountryListUseCase().onEach {

                when(it){
                    is Resource.Loading->{
                        _list.value = CountryListState(isLoading = true)
                    }
                    is Resource.Success->{
                        _list.value= CountryListState(data = it.data)
                    }
                    is Resource.Error->{
                        _list.value = CountryListState(error=it.message.toString())
                    }
                }
            }.launchIn(viewModelScope)
        }


}