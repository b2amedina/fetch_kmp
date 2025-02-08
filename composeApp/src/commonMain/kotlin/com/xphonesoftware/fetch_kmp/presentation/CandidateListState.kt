package com.xphonesoftware.fetch_kmp.presentation

import androidx.compose.runtime.Immutable
import com.xphonesoftware.fetch_kmp.presentation.models.CandidateUi

@Immutable
data class CandidateListState(
    val isLoading: Boolean = false,
    val candidates: List<CandidateUi> = emptyList(),
    val selectedCandidate: CandidateUi? = null
)
