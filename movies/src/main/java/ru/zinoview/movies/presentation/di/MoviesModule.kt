package ru.zinoview.movies.presentation.di

import dagger.Module
import dagger.Provides
import ru.zinoview.core.ResourceProvider
import ru.zinoview.movies.domain.MoviesInteractor
import ru.zinoview.movies.presentation.MoviesViewModelFactory

@Module(includes = [DataModule::class,DomainModule::class])
object MoviesModule {

    @Provides
    @MoviesScope
    fun provideMoviesViewModelFactory(
        interactor: MoviesInteractor.Delay,
        resourceProvider: ResourceProvider
    ): MoviesViewModelFactory = MoviesViewModelFactory.Base(interactor, resourceProvider)

}