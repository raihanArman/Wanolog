package com.ewalabs.kiiroi

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform