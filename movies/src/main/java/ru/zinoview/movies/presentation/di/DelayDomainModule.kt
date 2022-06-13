package ru.zinoview.movies.presentation.di

import dagger.Module
import dagger.Provides
import ru.zinoview.movies.domain.MoviesInteractor

@Module
@MoviesScope
object DelayDomainModule {

    @Provides
    @MoviesScope
    fun provideDelayMoviesInteractor(interactor: MoviesInteractor) : MoviesInteractor.Delay
        = MoviesInteractor.Delay(DELAY,interactor)


    private const val DELAY = 3000L
}