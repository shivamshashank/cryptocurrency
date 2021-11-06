package com.brighterbee.tech.cryptocurrency.data.remote

import com.brighterbee.tech.cryptocurrency.data.remote.dto.coin.CoinDto
import com.brighterbee.tech.cryptocurrency.data.remote.dto.coin_details.CoinDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>


    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailsDto

}