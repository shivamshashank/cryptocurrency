package com.brighterbee.tech.cryptocurrency.data.repository

import com.brighterbee.tech.cryptocurrency.data.remote.CoinPaprikaApi
import com.brighterbee.tech.cryptocurrency.data.remote.dto.coin.CoinDto
import com.brighterbee.tech.cryptocurrency.data.remote.dto.coin_details.CoinDetailsDto
import com.brighterbee.tech.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return api.getCoinById(coinId)
    }

}