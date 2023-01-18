package org.owls.common

interface InputReader<out T> {
    fun read(): T
}