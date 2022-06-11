package ru.zinoview.movies.data.cloud

import ru.zinoview.movies.core.ExtraMovieData
import ru.zinoview.movies.core.MainMovieData
import ru.zinoview.movies.core.MovieMapper

interface ToCloudMovieMapper : MovieMapper<CloudMovies.CloudMovie> {

    class Base : ToCloudMovieMapper {

        override fun map(
            mainData: MainMovieData,
            extraData: ExtraMovieData
        ): CloudMovies.CloudMovie = CloudMovies.CloudMovie.Mapped(mainData,extraData)
    }
}