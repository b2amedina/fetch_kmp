package com.xphonesoftware.fetch_kmp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import fetchkmp.composeapp.generated.resources.Res
import fetchkmp.composeapp.generated.resources.candidate_screen_title
import org.jetbrains.compose.resources.stringResource


@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(Res.string.candidate_screen_title),
                    style = MaterialTheme.typography.h4
                )
            }
        }
    )
}
