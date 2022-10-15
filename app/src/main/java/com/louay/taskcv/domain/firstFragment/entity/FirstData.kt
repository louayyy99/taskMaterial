package com.louay.taskcv.domain.firstFragment.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FirstData(
    var name: String = "",
    var email: String = "",
    var age: Int = 0,
    var gender: String = "",
) : Parcelable