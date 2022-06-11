package ru.zinoview

interface Mapper<S,R> {

    fun map(src: S) : ru.zinoview.R
}