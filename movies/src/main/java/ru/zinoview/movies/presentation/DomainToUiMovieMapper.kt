package ru.zinoview.movies.presentation

import ru.zinoview.movies.core.ExtraMovieData
import ru.zinoview.movies.core.MainMovieData
import ru.zinoview.movies.core.MovieMapper
import javax.inject.Inject

interface DomainToUiMovieMapper : MovieMapper<UiMovie> {

    class Base @Inject constructor() : DomainToUiMovieMapper {

        override fun map(mainData: MainMovieData, extraData: ExtraMovieData): UiMovie
            = mainData.map(extraData)
    }
}