package com.louay.taskcv.domain.secondFragment.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SecondData(
    var androidValue:Int = 0,
    var IosValue:Int = 0,
    var flutterValue:Int = 0,
    var isArabic:Boolean = false,
    var isEnglish:Boolean = false,
    var isFrench:Boolean = false,
    var isMusic:Boolean = false,
    var isSports:Boolean = false,
    var isGames:Boolean = false,
) : Parcelable