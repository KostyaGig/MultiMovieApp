package ru.zinoview.movies.core

interface BaseMovie {

    fun <T> map(mapper: MovieMapper<T>) : T
}