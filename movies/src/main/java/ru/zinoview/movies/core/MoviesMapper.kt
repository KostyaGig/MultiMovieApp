package ru.zinoview.movies.core

interface MoviesMapper<T,E> {

    fun map(movies: List<Movie>) : T

    fun map(error: E) : T
}