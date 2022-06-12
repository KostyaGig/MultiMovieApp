package ru.zinoview.movies.core

import ru.zinoview.movies.presentation.MovieSame

interface ExtraMovieData : MovieSame{

    override fun sameId(id: String) = false

    abstract class Base(
        private val description: String,
        private val year: String
    ) : ExtraMovieData {

        override fun sameData(description: String)
            = this.description == description
    }
    class WithDescription(
        private val description: String,
        private val year: String
    ) : Base(description, year) {


    }

    class EmptyDescription(
        private val year: String
    ) : Base("",year)
}