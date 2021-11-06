package com.brighterbee.tech.cryptocurrency.domain.use_case.get_coins_list

import com.brighterbee.tech.cryptocurrency.common.Resource
import com.brighterbee.tech.cryptocurrency.data.remote.dto.coin.toCoin
import com.brighterbee.tech.cryptocurrency.domain.model.Coin
import com.brighterbee.tech.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsListUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coinsList = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coinsList))
        } catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException){
            emit(Resource.Error<List<Coin>>("You are offline!"))
        }
    }

}