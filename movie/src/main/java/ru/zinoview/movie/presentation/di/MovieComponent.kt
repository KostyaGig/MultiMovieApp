package ru.zinoview.movie.presentation.di

import dagger.Component
import ru.zinoview.movie.presentation.MovieViewModelFactory

@Component(modules = [MovieModule::class])
@MovieScope
interface MovieComponent : ru.zinoview.core.di.Component {

    // todo move to interface
    fun movieViewModelFactory() : MovieViewModelFactory

    @Component.Builder
    interface Builder{

        fun build() : MovieComponent
    }
}