package com.louay.taskcv.data.firstFragment.repo

import android.content.SharedPreferences
import com.google.gson.Gson
import com.louay.taskcv.data.firstFragment.dto.DataRequest
import com.louay.taskcv.domain.firstFragment.Repo
import com.louay.taskcv.domain.firstFragment.entity.FirstData
import com.louay.taskcv.utils.UiState

class RepoImpl(
    val appPreferences: SharedPreferences,
    val gson: Gson,
) : Repo {
    override fun saveData(dataRequest: DataRequest, result: (UiState<String>) -> Unit) {
        appPreferences.edit().putString("firstData", gson.toJson(dataRequest)).apply().also {
            result(UiState.Success("Data saved successfully"))
        }
    }

    override fun getFirstData(result: (FirstData?) -> Unit) {
        val fData = appPreferences.getString("firstData", null)
        if (fData == null) {
            result.invoke(null)
        } else {
            val data = gson.fromJson(fData, FirstData::class.java)
            result.invoke(data)
        }
    }
}