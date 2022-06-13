package ru.zinoview.movies.presentation

import ru.zinoview.coremoviemodule.UiDetailMovie
import ru.zinoview.movies.core.ExtraMovieData
import ru.zinoview.movies.core.MainMovieData
import ru.zinoview.movies.core.MovieMapper

interface ToDetailMovieMapper : MovieMapper<UiDetailMovie> {

    class Base(
        private val mapper: ToMovieArgumentsMapper<UiDetailMovie>
    ) : ToDetailMovieMapper {

        override fun map(mainData: MainMovieData, extraData: ExtraMovieData): UiDetailMovie
            = mainData.map(extraData,mapper)
    }
}