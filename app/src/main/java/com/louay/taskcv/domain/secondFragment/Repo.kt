package com.louay.taskcv.domain.secondFragment

import com.louay.taskcv.data.secondFragment.dto.DataRequest
import com.louay.taskcv.domain.secondFragment.entity.SecondData
import com.louay.taskcv.utils.UiState

interface Repo {
    fun saveData(dataRequest: DataRequest, result: (UiState<String>) -> Unit)
    fun getSecondData(result: (SecondData?) -> Unit)
}