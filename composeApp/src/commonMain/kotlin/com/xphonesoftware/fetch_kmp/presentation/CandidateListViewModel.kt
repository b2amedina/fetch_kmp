package com.xphonesoftware.fetch_kmp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xphonesoftware.fetch.domain.CandidateDataSource
import com.xphonesoftware.fetch_kmp.presentation.models.CandidateUi
import com.xphonesoftware.fetch_kmp.presentation.models.toCandidateUi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CandidateListViewModel (
    private val candidateDataSource: CandidateDataSource
): ViewModel() {
    private val _state = MutableStateFlow(CandidateListState())
    val state = _state.asStateFlow()

    private fun load() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            delay(3_000) // FIXME - remove, just so spinner displays
            val candidates = candidateDataSource.getCandidates()
            _state.update {
                it.copy(
                    isLoading = false,
                    candidates = candidates.map { candidate -> candidate.toCandidateUi() }
                )
            }
        }
    }

    init {
        load()
    }

    fun onAction(action: CandidateListAction) {
        when (action) {
            is CandidateListAction.OnItemClicked -> {
                selectCandidate(candidateUi = action.candidateUi)
            }
        }
    }

    private fun selectCandidate(candidateUi: CandidateUi) {
        _state.update {
            it.copy(selectedCandidate = candidateUi)
        }
    }
}