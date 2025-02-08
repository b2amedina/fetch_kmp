package com.xphonesoftware.fetch_kmp.data

import com.xphonesoftware.fetch.domain.Candidate

fun CandidateDto.toCandidate(): Candidate {
    return Candidate(
        id = id,
        listId = listId,
        name = name!!
    )
}