package com.brighterbee.tech.cryptocurrency.domain.use_case.get_single_coin

import com.brighterbee.tech.cryptocurrency.common.Resource
import com.brighterbee.tech.cryptocurrency.data.remote.dto.coin_details.toCoinDetails
import com.brighterbee.tech.cryptocurrency.domain.model.CoinDetails
import com.brighterbee.tech.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSingleCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading<CoinDetails>())
            val coinDetails = coinRepository.getCoinById(coinId).toCoinDetails()
            emit(Resource.Success<CoinDetails>(coinDetails))
        } catch (e: HttpException){
            emit(Resource.Error<CoinDetails>(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException){
            emit(Resource.Error<CoinDetails>("You are offline!"))
        }
    }

}