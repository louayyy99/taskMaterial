package com.louay.taskcv.data.secondFragment.repo

import android.content.SharedPreferences
import com.google.gson.Gson
import com.louay.taskcv.data.secondFragment.dto.DataRequest
import com.louay.taskcv.domain.secondFragment.Repo
import com.louay.taskcv.domain.secondFragment.entity.SecondData
import com.louay.taskcv.utils.UiState

class RepoImpl(
    val appPreferences: SharedPreferences,
    val gson: Gson,
) : Repo {
    override fun saveData(dataRequest: DataRequest, result: (UiState<String>) -> Unit) {
        appPreferences.edit().putString("secondData", gson.toJson(dataRequest)).apply().also {
            result(UiState.Success("Data saved successfully"))
        }
    }

    override fun getSecondData(result: (SecondData?) -> Unit) {
        val sData = appPreferences.getString("secondData", null)
        if (sData == null) {
            result.invoke(null)
        } else {
            val data = gson.fromJson(sData, SecondData::class.java)
            result.invoke(data)
        }
    }
}