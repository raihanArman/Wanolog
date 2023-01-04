package com.ewalabs.core.arch

import com.ewalabs.core.DataResource
import com.ewalabs.core.exception.ApiErrorException
import com.ewalabs.core.exception.NoInternetConnectionException
import com.ewalabs.core.exception.UnexpectedApiErrorException
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.utils.io.errors.*


/**
 * @author Raihan Arman
 * @date 14/07/2022
 */
open class BaseRepositoryImpl: BaseContract.BaseRepository {
    override fun logResponse(msg: String?) {
//        Log.d(BaseRepositoryImpl::class.java.simpleName, msg.orEmpty())
    }

    suspend inline fun <reified T> safeNetwrokCall(crossinline apiCall: suspend () -> HttpResponse): DataResource<T> {
        return try {
            val call = apiCall.invoke()
            if(call.status.isSuccess()){
                val data: T = call.body()
                DataResource.Success(data)
            }else{
                DataResource.Error(ApiErrorException("Redirect", 0))
            }
        }catch (throwable: Throwable){
            when(throwable){
                is IOException -> DataResource.Error(NoInternetConnectionException())
                is ClientRequestException -> DataResource.Error(ApiErrorException("Client request error"))
                is ServerResponseException -> DataResource.Error(ApiErrorException("Server response error"))
                else ->{
                    DataResource.Error(UnexpectedApiErrorException())
                }
            }
        }
    }

    suspend fun <T> proceed(coroutine: suspend () -> T): DataResource<T> {
        return try {
            DataResource.Success(coroutine.invoke())
        }catch (excetion: Exception){
            DataResource.Error(excetion)
        }
    }

}