package ru.zinoview.movies.data.cloud

import ru.zinoview.core.Data
import javax.inject.Inject

interface MoviesCloudDataSource : Data<List<CloudMovies.CloudMovie>> {

    class Base @Inject constructor(
        private val service: MoviesService,
        private val mapper: ToCloudMovieMapper,
        private val shortDescription: Description,
        private val emptyDescription: Description
    ) : MoviesCloudDataSource {

        override suspend fun data(): List<CloudMovies.CloudMovie> =
            service.movies().map(Triple(mapper,shortDescription,emptyDescription))
    }
}