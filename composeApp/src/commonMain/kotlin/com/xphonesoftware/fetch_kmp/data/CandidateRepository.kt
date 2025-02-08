package com.xphonesoftware.fetch_kmp.data

import com.xphonesoftware.fetch.domain.Candidate
import com.xphonesoftware.fetch.domain.CandidateDataSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.isSuccess

class CandidateRepository(
    private val httpClient: HttpClient
) : CandidateDataSource {
    private val BASE_URL: String = "http://fetch-hiring.s3.amazonaws.com/"

    override suspend fun getCandidates(): List<Candidate> {
        val response = httpClient.get(
            urlString = BASE_URL.plus("hiring.json")
        )
        if (response.status.isSuccess()) {
            val candidates = response.body<List<CandidateDto>>()
                .filter { !it.name.isNullOrBlank() }
                .sortedWith( compareBy({ it.listId }, { it.id }) )
            return candidates.map { it.toCandidate() }
        }
        return emptyList()
    }
}