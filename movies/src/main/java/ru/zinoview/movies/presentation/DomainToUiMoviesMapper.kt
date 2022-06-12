package ru.zinoview.movies.presentation

import ru.zinoview.movies.core.*
import ru.zinoview.movies.domain.DataToDomainExceptionMapper
import ru.zinoview.movies.domain.DomainException

interface DomainToUiMoviesMapper : MoviesMapper<List<UiMovie>,DomainException> {

    class Base(
        private val mapper: DomainToUiMovieMapper,
        private val exceptionMapper: DomainExceptionToUiStringMapper
    ) : DomainToUiMoviesMapper {

        override fun map(movies: List<Movie>) = movies.map { movie -> movie.map(mapper)   }

        override fun map(error: DomainException) = listOf(
            UiMovie.Failure(exceptionMapper.map(error))
        )
    }
}