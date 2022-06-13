package ru.zinoview.movies.domain

import ru.zinoview.movies.core.Movie
import ru.zinoview.movies.core.MoviesMapper
import java.lang.Exception
import javax.inject.Inject

interface DataToDomainMoviesMapper : MoviesMapper<DomainMovies,Exception> {

    class Base @Inject constructor(
        private val mapper: DataToDomainExceptionMapper
    ) : DataToDomainMoviesMapper {
        override fun map(movies: List<Movie>)
            = DomainMovies.Success(movies)

        override fun map(error: Exception)
            = DomainMovies.Failure(mapper.map(error))
    }
}