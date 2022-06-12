package ru.zinoview.movies.presentation

import ru.zinoview.coreuimodule.UiModel

interface UiMovies : UiModel {

    class Base(
        private val movies: List<UiMovie>
    ) : UiMovies
}