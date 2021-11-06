package com.brighterbee.tech.cryptocurrency.data.remote.dto.coin_details


import com.google.gson.annotations.SerializedName

data class Whitepaper(
    @SerializedName("link")
    val link: Any,
    @SerializedName("thumbnail")
    val thumbnail: Any
)