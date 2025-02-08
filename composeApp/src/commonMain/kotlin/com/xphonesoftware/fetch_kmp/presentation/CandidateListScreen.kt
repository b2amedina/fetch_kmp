package com.xphonesoftware.fetch_kmp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.xphonesoftware.fetch_kmp.presentation.components.AppBar
import com.xphonesoftware.fetch_kmp.presentation.components.CandidateItem
import com.xphonesoftware.fetch_kmp.presentation.models.CandidateUi

@Composable
fun CandidateListScreen(
    state: CandidateListState,
    onAction: (CandidateListAction) -> Unit,
    modifier: Modifier = Modifier
) {

    val groupedItems: Map<String, List<CandidateUi>> =
        state.candidates.groupBy { it.listId.toString() }

    MaterialTheme {
        Scaffold(
            topBar = {
                AppBar()
            },
        ) { innerPadding ->
            if (state.isLoading) {
                Box(
                    modifier = modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                ) {
                    groupedItems.forEach { (groupKey, itemsInCategory) ->
                        item {
                            Text(
                                text = "Group $groupKey",
                                style = MaterialTheme.typography.h5,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                        }
                        items(itemsInCategory) { candidateUi ->
                            CandidateItem(
                                candidateUi = candidateUi,
                                onClick = {
                                    onAction(CandidateListAction.OnItemClicked(candidateUi))
                                },
                                modifier = Modifier.fillMaxWidth(),
                                isSelected = candidateUi == state.selectedCandidate
                            )
                        }
                    }
                }
            }
        }
    }
}

