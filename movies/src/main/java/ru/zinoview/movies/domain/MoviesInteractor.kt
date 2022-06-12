package ru.zinoview.movies.domain

import ru.zinoview.core.Data
import ru.zinoview.movies.data.DataMovies
import ru.zinoview.movies.data.MoviesRepository

interface MoviesInteractor : Data<DomainMovies> {

    class Base(
        private val repository: MoviesRepository<DataMovies>,
        private val mapper: DataToDomainMoviesMapper
    ) : MoviesInteractor {

        override suspend fun data(): DomainMovies = repository.data().map(mapper)
    }
}