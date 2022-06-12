package ru.zinoview.movies.core

interface BaseMovie {

    fun <T> map(mapper: MovieMapper<T>) : T = throw IllegalArgumentException("BaseMovie.map doesn't process")
}