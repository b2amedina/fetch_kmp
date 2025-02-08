package com.xphonesoftware.fetch_kmp

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.xphonesoftware.fetch_kmp.di.appModule
import com.xphonesoftware.fetch_kmp.presentation.CandidateListScreen
import com.xphonesoftware.fetch_kmp.presentation.CandidateListViewModel
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        val viewModel: CandidateListViewModel = koinViewModel()
        CandidateListScreen(
            state = viewModel.state.collectAsStateWithLifecycle().value,
            onAction = { action -> viewModel.onAction(action) },
            modifier = Modifier
                .background(MaterialTheme.colors.background)
        )
    }
}