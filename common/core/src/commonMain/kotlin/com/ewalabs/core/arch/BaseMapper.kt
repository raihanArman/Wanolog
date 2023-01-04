package com.ewalabs.core.arch

/**
 * @author Raihan Arman
 * @date 11/10/22
 */

abstract class BaseMapper<in T, out R> {
    abstract fun map(value: T): R
}