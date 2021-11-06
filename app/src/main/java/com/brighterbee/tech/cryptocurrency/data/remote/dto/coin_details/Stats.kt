package com.brighterbee.tech.cryptocurrency.data.remote.dto.coin_details


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("members")
    val members: Int,
    @SerializedName("subscribers")
    val subscribers: Int
)