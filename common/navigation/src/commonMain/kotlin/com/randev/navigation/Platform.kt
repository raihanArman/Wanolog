package com.randev.navigation

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform