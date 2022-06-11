package ru.zinoview.movies.core

interface BaseMovies<E> {

    fun <T> map(mapper: MoviesMapper<T,E>) : T
}