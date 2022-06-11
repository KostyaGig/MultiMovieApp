package ru.zinoview.movies.core

interface MovieMapper<T> {

    fun map(mainData: MainMovieData, extraData: ExtraMovieData) : T
}