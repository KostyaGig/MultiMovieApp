package ru.zinoview.movies.domain

import ru.zinoview.movies.core.BaseMovies
import ru.zinoview.movies.core.Movie
import ru.zinoview.movies.core.MoviesMapper

sealed class DomainMovies : BaseMovies<DomainException> {

    class Success(
        private val movies: List<Movie>
    ) : DomainMovies() {

        override fun <T> map(mapper: MoviesMapper<T, DomainException>)
            = mapper.map(movies)
    }

    class Failure(
        private val exception: DomainException
    ) : DomainMovies() {

        override fun <T> map(mapper: MoviesMapper<T, DomainException>)
            = mapper.map(exception)
    }
}
