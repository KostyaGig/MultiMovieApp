package ru.zinoview.movies.core

interface MainMovieData {

    data class Base(
        private val id: String,
        private val image: String,
        private val title: String
    ) : MainMovieData

    data class EmptyImage(
        private val id: String,
        private val title: String
    ) : MainMovieData
}