package ru.zinoview.movies.presentation.di

import dagger.Component
import ru.zinoview.core.di.CoreComponent
import ru.zinoview.movies.presentation.MoviesViewModelFactory

@Component(modules = [MoviesModule::class], dependencies = [CoreComponent::class])
@MoviesScope
interface MoviesComponent : ru.zinoview.core.di.Component {

    fun moviesViewModelFactory() : MoviesViewModelFactory

    @Component.Builder
    interface Builder {

        fun coreComponent(coreComponent: CoreComponent) : Builder

        fun build() : MoviesComponent
    }

    object Empty : MoviesComponent {
        override fun moviesViewModelFactory()
            = MoviesViewModelFactory.Empty
    }
}