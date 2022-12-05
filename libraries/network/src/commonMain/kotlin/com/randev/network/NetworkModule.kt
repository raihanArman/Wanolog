package com.randev.network

import com.randev.core.exception.ApiException
import com.randev.preferences.ACCESS_TOKEN_KEY
import com.randev.preferences.Preferences
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 11/10/22
 */

val networkModule = module {
    single { createJson() }
    single { createKtorClient(get(), get(), get()) }
}


fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

fun createKtorClient(httpClientEngine: HttpClientEngine, json: Json, preferences: Preferences) = HttpClient(httpClientEngine) {
    val accessToken = runBlocking {
        preferences.getStringOrDefault(ACCESS_TOKEN_KEY, "").first()
    }

    install(ContentNegotiation) {
        json(json = json)
    }

    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = Configs.BASE_URL

            headers {
                append(HttpHeaders.Accept, "application/vnd.api+json")
                append(HttpHeaders.ContentType, "application/vnd.api+json")
            }

            if (accessToken.isNotEmpty()) {
                bearerAuth(accessToken)
            }

        }
    }

    install(HttpTimeout) {
        this.requestTimeoutMillis = 60000
        this.connectTimeoutMillis = 60000
        this.socketTimeoutMillis = 60000
    }

    HttpResponseValidator {
        handleResponseExceptionWithRequest { exception, _ ->
            when (exception) {
                is ServerResponseException -> {
                    val serverResponseResponse = exception.response
                    val serverResponseExceptionText = serverResponseResponse.bodyAsText()
                    val apiException = json.decodeFromString(ApiException.serializer(), serverResponseExceptionText)
                    throw apiException
                }
                is ClientRequestException -> {
                    val exceptionResponse = exception.response
                    val exceptionResponseText = exceptionResponse.bodyAsText()
                    val apiException = json.decodeFromString(ApiException.serializer(), exceptionResponseText)
                    throw apiException
                }
                else -> {
                    return@handleResponseExceptionWithRequest
                }
            }
        }
    }

    install(Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.BODY
    }

}

object Configs {
    const val BASE_URL = "kitsu.io"
}