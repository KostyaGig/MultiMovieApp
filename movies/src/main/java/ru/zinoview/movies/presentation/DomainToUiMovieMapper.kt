package ru.zinoview.movies.presentation

import ru.zinoview.movies.core.ExtraMovieData
import ru.zinoview.movies.core.MainMovieData
import ru.zinoview.movies.core.MovieMapper

interface DomainToUiMovieMapper : MovieMapper<UiMovie> {

    class Base : DomainToUiMovieMapper {

        override fun map(mainData: MainMovieData, extraData: ExtraMovieData): UiMovie
            = UiMovie.Base(mainData,extraData)
    }
}