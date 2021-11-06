package com.brighterbee.tech.cryptocurrency.domain.model

import com.brighterbee.tech.cryptocurrency.data.remote.dto.coin_details.Team

data class CoinDetails(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<Team>,
)
