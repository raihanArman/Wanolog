package com.ewalabs.kmmmovieapp.base.arch

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesIgnore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

@NativeCoroutinesIgnore
fun <T>execute(
    context: CoroutineContext = Dispatchers.Default,
    block: suspend () -> T
): Flow<T> {
    return flow {
        try {
            val out = block.invoke()
            emit(out)
        }
        catch (e: Throwable) {
            throw e
        }
    }.flowOn(context)
}
