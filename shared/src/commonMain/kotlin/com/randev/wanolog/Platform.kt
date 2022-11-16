package com.randev.wanolog

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform