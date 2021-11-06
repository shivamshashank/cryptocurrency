package com.brighterbee.tech.cryptocurrency.presentation.coin_list

import com.brighterbee.tech.cryptocurrency.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coinList: List<Coin> = emptyList(),
    val error: String = "",
)
