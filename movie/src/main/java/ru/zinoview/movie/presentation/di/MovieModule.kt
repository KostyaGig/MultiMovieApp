package ru.zinoview.movie.presentation.di

import dagger.Module
import dagger.Provides
import ru.zinoview.movie.presentation.MovieViewModelFactory

@Module
@MovieScope
object MovieModule {

    @Provides
    @MovieScope
    fun provideMovieViewModelFactory() : MovieViewModelFactory
        = MovieViewModelFactory.Base()
}