package com.xphonesoftware.fetch_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform