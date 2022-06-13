package ru.zinoview.movies.presentation.di

import dagger.Binds
import dagger.Module
import ru.zinoview.movies.data.DataMovies
import ru.zinoview.movies.data.MoviesRepository
import ru.zinoview.movies.data.ToMovieMapper

@Module(includes = [NetworkModule::class])
@MoviesScope
interface DataModule {

    @Binds
    @MoviesScope
    fun bindMoviesRepository(repository: MoviesRepository.Base) : MoviesRepository<DataMovies>

    @Binds
    @MoviesScope
    fun bindToMovieMapper(mapper: ToMovieMapper.Base) : ToMovieMapper
}