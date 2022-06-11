package ru.zinoview.movies.data

import ru.zinoview.movies.core.BaseMovies
import ru.zinoview.movies.core.Movie
import ru.zinoview.movies.core.MoviesMapper
import java.lang.Exception

sealed class DataMovies : BaseMovies<Exception> {

    class Success(
        private val movies: List<Movie>
    ) : DataMovies() {

        override fun <T> map(mapper: MoviesMapper<T, Exception>)
            = mapper.map(movies)
    }

    class Failure(
        private val exception: Exception
    ) : DataMovies() {

        override fun <T> map(mapper: MoviesMapper<T, Exception>)
            = mapper.map(exception)
    }
}
