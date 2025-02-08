package com.xphonesoftware.fetch_kmp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.xphonesoftware.fetch_kmp.presentation.models.CandidateUi
import org.jetbrains.compose.resources.painterResource

@Composable
fun CandidateItem(
    candidateUi: CandidateUi,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {
    val selectedColor = if (isSelected) MaterialTheme.colors.secondary else MaterialTheme.colors.surface
    Card(
        backgroundColor = selectedColor,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(
                elevation = 15.dp,
                shape = RectangleShape,
            )
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Icon(
                painter = painterResource(candidateUi.drawable),
                contentDescription = candidateUi.name,
                modifier = Modifier.size(48.dp)
            )
            Text(
                text = candidateUi.name,
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.h6
            )
        }
    }
}
