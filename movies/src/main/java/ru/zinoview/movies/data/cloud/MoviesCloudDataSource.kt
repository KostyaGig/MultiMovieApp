package ru.zinoview.movies.data.cloud

import ru.zinoview.core.Data
import javax.inject.Inject

interface MoviesCloudDataSource : Data<List<CloudMovies.CloudMovie>> {

    class Base @Inject constructor(
        private val service: MoviesService,
        private val mapper: ToCloudMovieMapper
    ) : MoviesCloudDataSource {

        override suspend fun data(): List<CloudMovies.CloudMovie> =
            service.movies().map(mapper)
    }
}