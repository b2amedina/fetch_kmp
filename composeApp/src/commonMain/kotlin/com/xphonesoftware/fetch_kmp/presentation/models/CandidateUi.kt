package com.xphonesoftware.fetch_kmp.presentation.models

import com.xphonesoftware.fetch.domain.Candidate
import com.xphonesoftware.fetch_kmp.presentation.getDrawableForCandidate
import org.jetbrains.compose.resources.DrawableResource

data class CandidateUi (
    val id: Int,
    val listId: Int,
    val name: String,
    val drawable: DrawableResource,
)

fun Candidate.toCandidateUi(): CandidateUi {
    return CandidateUi(
        id = id,
        listId = listId,
        name = name,
        drawable = getDrawableForCandidate(name)
    )
}