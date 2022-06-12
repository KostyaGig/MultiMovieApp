package ru.zinoview.movies.domain

import kotlinx.coroutines.delay
import ru.zinoview.core.Data
import ru.zinoview.movies.data.DataMovies
import ru.zinoview.movies.data.MoviesRepository
import javax.inject.Inject

interface MoviesInteractor : Data<DomainMovies> {

    class Base (
        private val repository: MoviesRepository<DataMovies>,
        private val mapper: DataToDomainMoviesMapper
    ) : MoviesInteractor {

        override suspend fun data(): DomainMovies = repository.data().map(mapper)
    }

    class Delay (
        private val delay: Long,
        private val interactor: MoviesInteractor
    ) : MoviesInteractor {

        override suspend fun data(): DomainMovies {
            delay(delay)
            return interactor.data()
        }
    }
}