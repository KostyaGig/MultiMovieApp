package ru.zinoview.movies.presentation

import ru.zinoview.coreuimodule.UiModel

interface UiMovies : UiModel {

    data class Base(
        private val movies: List<UiMovie>
    ) : UiMovies
}