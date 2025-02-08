package com.xphonesoftware.fetch_kmp.di

import com.xphonesoftware.fetch.domain.CandidateDataSource
import com.xphonesoftware.fetch_kmp.data.CandidateRepository
import com.xphonesoftware.fetch_kmp.data.HttpClientFactory
import com.xphonesoftware.fetch_kmp.presentation.CandidateListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::CandidateRepository).bind<CandidateDataSource>()
    viewModel { CandidateListViewModel(get()) }
}