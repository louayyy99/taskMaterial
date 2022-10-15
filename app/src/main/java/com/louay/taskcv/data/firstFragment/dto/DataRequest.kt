package com.louay.taskcv.data.firstFragment.dto

import com.google.gson.annotations.SerializedName

data class DataRequest(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("age") val age: String,
    @SerializedName("gender") val gender: String,
)