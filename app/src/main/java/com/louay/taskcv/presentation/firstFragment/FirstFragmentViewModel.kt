package com.louay.taskcv.presentation.firstFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.louay.taskcv.data.firstFragment.dto.DataRequest
import com.louay.taskcv.domain.firstFragment.Repo
import com.louay.taskcv.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstFragmentViewModel @Inject constructor(
    private val repo: Repo,
) :
    ViewModel() {
    private val _state = MutableLiveData<UiState<String>>()
    val state: LiveData<UiState<String>>
        get() = _state

    fun saveData(dataRequest: DataRequest) {
        _state.value = UiState.Loading
        repo.saveData(dataRequest) {
            _state.value = it
        }
    }
}