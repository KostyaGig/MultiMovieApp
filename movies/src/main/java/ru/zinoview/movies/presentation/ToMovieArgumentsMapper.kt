package ru.zinoview.movies.presentation

interface ToMovieArgumentsMapper<T> {

    fun map(title: String,description: String,url: String) : T

    class UiDetailMovie : ToMovieArgumentsMapper<ru.zinoview.coremoviemodule.UiDetailMovie> {

        override fun map(
            title: String,
            description: String,
            url: String
        ) = ru.zinoview.coremoviemodule.UiDetailMovie.Base(title,description,url)
    }
}