package ru.zinoview.movies.core

interface MainMovieData {

    fun title() : String

    data class Base(
        private val id: String,
        private val image: String,
        private val title: String
    ) : MainMovieData {

        // todo
        override fun title(): String = title
    }

    data class EmptyImage(
        private val id: String,
        private val title: String
    ) : MainMovieData {
        // todo
        override fun title(): String = title
    }
}