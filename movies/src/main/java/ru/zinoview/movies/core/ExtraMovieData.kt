package ru.zinoview.movies.core

interface ExtraMovieData {

    class Base(
        private val description: String,
        private val year: String
    ) : ExtraMovieData

    class EmptyDescription(
        private val year: String
    ) : ExtraMovieData
}