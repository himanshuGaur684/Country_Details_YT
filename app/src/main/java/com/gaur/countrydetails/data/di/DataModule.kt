package com.gaur.countrydetails.data.di

import com.gaur.countrydetails.data.network.ApiService
import com.gaur.countrydetails.data.repository.CountryRepoImpl
import com.gaur.countrydetails.domain.repository.CountryRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {


    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl("https://travelbriefing.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideCountryRepo(apiService:ApiService):CountryRepo{
        return CountryRepoImpl(apiService)
    }


}