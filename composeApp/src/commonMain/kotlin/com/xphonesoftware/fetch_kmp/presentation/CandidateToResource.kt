package com.xphonesoftware.fetch_kmp.presentation

import fetchkmp.composeapp.generated.resources.Res
import fetchkmp.composeapp.generated.resources.candidate
import org.jetbrains.compose.resources.DrawableResource

fun getDrawableForCandidate(name: String): DrawableResource {
    return Res.drawable.candidate;
}