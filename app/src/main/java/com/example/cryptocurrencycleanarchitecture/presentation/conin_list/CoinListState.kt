package com.example.cryptocurrencycleanarchitecture.presentation.conin_list

import com.example.cryptocurrencycleanarchitecture.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""

)
