package ru.zinoview.movies.presentation

import ru.zinoview.core.Show
import ru.zinoview.coreuimodule.UiModel

interface UiMovies : UiModel, Show<MoviesAdapter> {

    data class Base(
        private val movies: List<UiMovie>
    ) : UiMovies {

        override fun show(adapter: MoviesAdapter)
            = adapter.update(movies)
    }
}