package ru.zinoview.movies.presentation.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.zinoview.core.ResourceProvider
import ru.zinoview.movies.data.cloud.Description
import ru.zinoview.movies.data.cloud.MoviesCloudDataSource
import ru.zinoview.movies.data.cloud.MoviesService
import ru.zinoview.movies.data.cloud.ToCloudMovieMapper

@Module
@MoviesScope
object NetworkModule {

    @Provides
    @MoviesScope
    fun provideMoviesService(retrofit: Retrofit): MoviesService =
        retrofit.create(MoviesService::class.java)

    @Provides
    @MoviesScope
    fun provideMoviesCloudDataSource(service: MoviesService,resourceProvider: ResourceProvider): MoviesCloudDataSource
        = MoviesCloudDataSource.Base(service,ToCloudMovieMapper.Base(),Description.Short(),Description.Empty(resourceProvider))
}