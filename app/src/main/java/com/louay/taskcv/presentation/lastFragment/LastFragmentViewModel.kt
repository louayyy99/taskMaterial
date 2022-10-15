package com.louay.taskcv.presentation.lastFragment

import androidx.lifecycle.ViewModel
import com.louay.taskcv.domain.firstFragment.Repo
import com.louay.taskcv.domain.firstFragment.entity.FirstData
import com.louay.taskcv.domain.secondFragment.entity.SecondData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LastFragmentViewModel @Inject constructor(
    private val firstRepo: Repo,
    private val secondRepo: com.louay.taskcv.domain.secondFragment.Repo,
) : ViewModel() {
    fun getFirstData(result: (FirstData?) -> Unit) {
        firstRepo.getFirstData(result)
    }

    fun getSecondData(result: (SecondData?) -> Unit) {
        secondRepo.getSecondData(result)
    }
}