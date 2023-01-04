package com.ewalabs.core.wrapper

import com.ewalabs.core.arch.BaseModel
import com.ewalabs.core.exception.ErrorCodesMapper
import com.ewalabs.core.exception.NetworkCodes
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withContext

/**
 * @author Raihan Arman
 * @date 11/10/22
 */
sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class GenericError(val code: Int, val message: String? = null) : ResultWrapper<Nothing>()
}

internal suspend fun <T: BaseModel> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T?
): ResultWrapper<T?> {
    return withContext(dispatcher) {
        try {
            val call = apiCall.invoke()
            when (call?.status) {
                true -> ResultWrapper.Success(call)
                else -> {
                    ResultWrapper.GenericError(
                        code = 0,
                        message = "Something went error"
                    )
                }
            }
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            when (throwable) {
                is TimeoutCancellationException -> {
                    ResultWrapper.GenericError(
                        code = NetworkCodes.TIMEOUT_ERROR,
                        message = ErrorCodesMapper.getMessage(NetworkCodes.CONNECTION_ERROR)
                    )
                }
                is IOException -> {
                    ResultWrapper.GenericError(
                        code = NetworkCodes.CONNECTION_ERROR,
                        message = ErrorCodesMapper.getMessage(NetworkCodes.CONNECTION_ERROR)
                    )
                }
                else -> {
                    ResultWrapper.GenericError(
                        code = NetworkCodes.GENERIC_ERROR,
                        message = throwable.message
                    )
                }
            }
        }
    }
}
