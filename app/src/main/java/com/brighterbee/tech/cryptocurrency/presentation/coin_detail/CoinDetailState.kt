package com.brighterbee.tech.cryptocurrency.presentation.coin_detail

import com.brighterbee.tech.cryptocurrency.domain.model.CoinDetails

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetails? = null,
    val error: String = "",
)