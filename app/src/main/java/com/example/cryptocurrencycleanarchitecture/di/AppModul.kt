package com.example.cryptocurrencycleanarchitecture.di

import com.example.cryptocurrencycleanarchitecture.common.Constants
import com.example.cryptocurrencycleanarchitecture.data.remote.CoinPaprikaApi
import com.example.cryptocurrencycleanarchitecture.data.repository.CoinRepositoryImpl
import com.example.cryptocurrencycleanarchitecture.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModul {

    @Provides
    @Singleton
    fun proivdePaprikaApi(): CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    //// provide repository
    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository{
        return CoinRepositoryImpl(api)
    }
}