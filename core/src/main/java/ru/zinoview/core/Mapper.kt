package ru.zinoview.core

interface Mapper<S,R> {

    fun map(src: S) : R
}