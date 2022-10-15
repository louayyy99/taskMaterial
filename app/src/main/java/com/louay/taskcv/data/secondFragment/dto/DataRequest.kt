package com.louay.taskcv.data.secondFragment.dto

import com.google.gson.annotations.SerializedName

data class DataRequest(
    @SerializedName("androidValue") val androidValue: Int,
    @SerializedName("IosValue") val IosValue: Int,
    @SerializedName("flutterValue") val flutterValue: Int,
    @SerializedName("isArabic") val isArabic: Boolean,
    @SerializedName("isEnglish") val isEnglish: Boolean,
    @SerializedName("isFrench") val isFrench: Boolean,
    @SerializedName("isMusic") val isMusic: Boolean,
    @SerializedName("isSports") val isSports: Boolean,
    @SerializedName("isGames") val isGames: Boolean,
)