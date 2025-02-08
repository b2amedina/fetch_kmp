package com.xphonesoftware.fetch_kmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xphonesoftware.fetch.domain.Candidate
import com.xphonesoftware.fetch_kmp.presentation.CandidateListScreen
import com.xphonesoftware.fetch_kmp.presentation.CandidateListState
import com.xphonesoftware.fetch_kmp.presentation.models.toCandidateUi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    CandidateListScreen(
        state = CandidateListState(
            isLoading = false,
            candidates = (1..100).map {
                Candidate(it, it, "Candidate $it").toCandidateUi()
            },
            selectedCandidate = null
        ),
        modifier = Modifier
            .background(MaterialTheme.colors.background),
        onAction = {}
    )
}