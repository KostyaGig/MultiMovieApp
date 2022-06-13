package ru.zinoview.movies.data

import ru.zinoview.movies.core.ExtraMovieData
import ru.zinoview.movies.core.MainMovieData
import ru.zinoview.movies.core.Movie
import ru.zinoview.movies.core.MovieMapper
import javax.inject.Inject

interface ToMovieMapper : MovieMapper<Movie> {

    class Base @Inject constructor(): ToMovieMapper {
        override fun map(mainData: MainMovieData, extraData: ExtraMovieData)
            = Movie.Base(mainData, extraData)
    }
}