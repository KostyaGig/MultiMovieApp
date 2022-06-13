package ru.zinoview.movies.presentation.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.zinoview.movies.data.DataMovies
import ru.zinoview.movies.data.MoviesRepository
import ru.zinoview.movies.data.ToMovieMapper
import ru.zinoview.movies.data.cloud.MoviesCloudDataSource
import ru.zinoview.movies.data.cloud.MoviesService
import ru.zinoview.movies.data.cloud.ToCloudMovieMapper
import ru.zinoview.movies.domain.DataToDomainExceptionMapper
import ru.zinoview.movies.domain.DataToDomainMoviesMapper
import ru.zinoview.movies.domain.MoviesInteractor

@Module(includes = [DelayDomainModule::class])
@MoviesScope
interface DomainModule {

    @Binds
    @MoviesScope
    fun bindBaseMoviesInteractor(repository: MoviesInteractor.Base) : MoviesInteractor

    @Binds
    @MoviesScope
    fun bindDataToDomainMoviesMapper(mapper: DataToDomainMoviesMapper.Base) : DataToDomainMoviesMapper

    @Binds
    @MoviesScope
    fun bindDataToDomainExceptionMapper(mapper: DataToDomainExceptionMapper.Base) : DataToDomainExceptionMapper
}