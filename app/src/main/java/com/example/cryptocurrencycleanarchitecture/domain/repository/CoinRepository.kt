package com.example.cryptocurrencycleanarchitecture.domain.repository

import com.example.cryptocurrencycleanarchitecture.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencycleanarchitecture.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}