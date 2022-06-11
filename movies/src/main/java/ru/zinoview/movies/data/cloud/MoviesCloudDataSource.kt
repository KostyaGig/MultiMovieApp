package ru.zinoview.movies.data.cloud

import ru.zinoview.core.Data
import ru.zinoview.core.cloud.NetworkServiceProvider

interface MoviesCloudDataSource : Data<List<CloudMovies.CloudMovie>> {

    class Base(
        private val networkServiceProvider: NetworkServiceProvider,
        private val mapper: ToCloudMovieMapper
    ) : MoviesCloudDataSource {

        override suspend fun data(): List<CloudMovies.CloudMovie> =
            networkServiceProvider.service(MoviesService::class.java).movies().map(mapper)
    }
}