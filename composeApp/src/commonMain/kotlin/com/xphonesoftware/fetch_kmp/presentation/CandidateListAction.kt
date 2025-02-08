package com.xphonesoftware.fetch_kmp.presentation

import com.xphonesoftware.fetch_kmp.presentation.models.CandidateUi

sealed interface CandidateListAction {
    data class OnItemClicked(val candidateUi: CandidateUi) : CandidateListAction
}