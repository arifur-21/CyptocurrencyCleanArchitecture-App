package com.example.cryptocurrencycleanarchitecture.domain.use_case.get_coin

import com.example.cryptocurrencycleanarchitecture.common.Resource
import com.example.cryptocurrencycleanarchitecture.data.remote.dto.toCoinDetail
import com.example.cryptocurrencycleanarchitecture.domain.model.CoinDetail
import com.example.cryptocurrencycleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {

            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.message() ?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("check your internet connection"))
        }
    }
}