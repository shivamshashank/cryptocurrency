package com.brighterbee.tech.cryptocurrency.domain.repository

import com.brighterbee.tech.cryptocurrency.data.remote.dto.coin.CoinDto
import com.brighterbee.tech.cryptocurrency.data.remote.dto.coin_details.CoinDetailsDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailsDto

}