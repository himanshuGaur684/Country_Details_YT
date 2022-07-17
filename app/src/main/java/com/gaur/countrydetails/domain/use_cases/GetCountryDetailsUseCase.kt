package com.gaur.countrydetails.domain.use_cases

import com.gaur.countrydetails.common.Resource
import com.gaur.countrydetails.domain.model.CountryDetails
import com.gaur.countrydetails.domain.repository.CountryRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class GetCountryDetailsUseCase (private val countryRepo: CountryRepo) {

    operator fun invoke(countryName:String) : Flow<Resource<CountryDetails>> = flow {

        emit(Resource.Loading())
        try{
            emit(Resource.Success(data =countryRepo.getCountryDetails(countryName = countryName)))

        }catch (e:Exception){
            emit(Resource.Error(message = e.message.toString()))
        }

    }.flowOn(Dispatchers.IO)

}