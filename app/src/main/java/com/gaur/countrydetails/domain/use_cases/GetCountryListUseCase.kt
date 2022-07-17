package com.gaur.countrydetails.domain.use_cases

import com.gaur.countrydetails.common.Resource
import com.gaur.countrydetails.domain.model.Country
import com.gaur.countrydetails.domain.repository.CountryRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class GetCountryListUseCase(private val countryRepo: CountryRepo)  {

    operator fun invoke():Flow<Resource<List<Country>>> = flow {
        emit(Resource.Loading())
        try{
            emit(Resource.Success(data = countryRepo.getCountryList()))

        }catch (e:Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)


}