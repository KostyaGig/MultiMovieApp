package ru.zinoview.movies.core

interface ExtraMovieData {

    class Base(
        private val description: String,
        private val year: String
    ) : ExtraMovieData
}