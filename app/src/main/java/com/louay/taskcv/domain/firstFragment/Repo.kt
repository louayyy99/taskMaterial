package com.louay.taskcv.domain.firstFragment

import com.louay.taskcv.data.firstFragment.dto.DataRequest
import com.louay.taskcv.domain.firstFragment.entity.FirstData
import com.louay.taskcv.utils.UiState

interface Repo {
    fun saveData(dataRequest: DataRequest, result: (UiState<String>) -> Unit)
    fun getFirstData(result: (FirstData?) -> Unit)
}