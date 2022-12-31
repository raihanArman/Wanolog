package com.randev.kiiroi

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform