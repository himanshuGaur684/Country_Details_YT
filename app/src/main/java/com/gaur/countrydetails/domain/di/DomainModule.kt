package com.gaur.countrydetails.domain.di

import com.gaur.countrydetails.domain.repository.CountryRepo
import com.gaur.countrydetails.domain.use_cases.GetCountryDetailsUseCase
import com.gaur.countrydetails.domain.use_cases.GetCountryListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {


    @Provides
    fun provideGetCountryListUseCase(countryRepo: CountryRepo):GetCountryListUseCase{
        return GetCountryListUseCase(countryRepo = countryRepo)
    }

    @Provides
    fun provideGetCountryDetailsUseCase(countryRepo: CountryRepo):GetCountryDetailsUseCase{
        return GetCountryDetailsUseCase(countryRepo = countryRepo)
    }

}