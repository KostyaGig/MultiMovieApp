package ru.zinoview.movies.presentation

import androidx.lifecycle.ViewModel
import ru.zinoview.movies.presentation.di.MoviesComponent

interface MoviesComponentViewModel {

    fun moviesViewModelFactory(component: MoviesComponent): MoviesViewModelFactory

    class Base : MoviesComponentViewModel, ViewModel() {

        private var moviesComponent: MoviesComponent = MoviesComponent.Empty

        override fun moviesViewModelFactory(component: MoviesComponent): MoviesViewModelFactory {
            moviesComponent = if (moviesComponent is MoviesComponent.Empty) {
                moviesComponent = component
                component
            } else {
                moviesComponent
            }

            return moviesComponent.moviesViewModelFactory()
        }
    }
}