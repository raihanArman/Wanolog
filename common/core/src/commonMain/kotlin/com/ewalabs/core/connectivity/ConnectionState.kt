package com.ewalabs.core.connectivity

/**
 * @author Raihan Arman
 * @date 12/12/22
 */
sealed class ConnectionState {
    object Available : ConnectionState()
    object Unavailable : ConnectionState()
}