package com.example.cryptocurrencycleanarchitecture.presentation.conin_details

import com.example.cryptocurrencycleanarchitecture.domain.model.Coin
import com.example.cryptocurrencycleanarchitecture.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""

)
