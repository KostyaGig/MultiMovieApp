package ru.zinoview.movies.presentation

import ru.zinoview.coreuimodule.Communication

interface UiMoviesCommunication : Communication<UiMovies> {

    class Base : UiMoviesCommunication, Communication.Base<UiMovies>()
}