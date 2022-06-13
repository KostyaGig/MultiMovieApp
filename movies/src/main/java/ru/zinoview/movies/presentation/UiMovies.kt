package ru.zinoview.movies.presentation

import androidx.recyclerview.widget.RecyclerView
import ru.zinoview.core.Show
import ru.zinoview.coreuimodule.UiModel

interface UiMovies : UiModel, Show<MoviesAdapter> {

    fun updateLayoutManager(recyclerView: RecyclerView, layoutManager: LayoutManager)

    data class Base(
        private val movies: List<UiMovie>
    ) : UiMovies {

        override fun show(adapter: MoviesAdapter)
            = adapter.update(movies)

        override fun updateLayoutManager(recyclerView: RecyclerView, manager: LayoutManager) {
            recyclerView.layoutManager = manager.map(movies.first())
        }
    }
}