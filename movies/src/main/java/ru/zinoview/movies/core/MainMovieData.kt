package ru.zinoview.movies.core

interface MainMovieData {

    class Base(
        private val id: String,
        private val image: String,
        private val title: String
    ) : MainMovieData{

    }
}