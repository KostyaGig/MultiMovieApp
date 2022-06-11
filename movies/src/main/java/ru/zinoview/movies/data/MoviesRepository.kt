package ru.zinoview.movies.data

import ru.zinoview.core.Data
import ru.zinoview.movies.data.cloud.MoviesCloudDataSource
import java.lang.Exception

interface MoviesRepository<T> : Data<T> {

    class Base(
        private val cloudDataSource: MoviesCloudDataSource,
        private val mapper: ToMovieMapper
    ) : MoviesRepository<DataMovies> {

        override suspend fun data(): DataMovies {
            return try {
                val movies = cloudDataSource.data().map { cloudMovie -> cloudMovie.map(mapper) }
                DataMovies.Success(movies)
            } catch (e: Exception) {
                DataMovies.Failure(e)
            }
        }
    }
}