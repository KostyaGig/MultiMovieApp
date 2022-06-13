package ru.zinoview.movies.core

import ru.zinoview.core.Mapper
import ru.zinoview.movies.presentation.UiMovie

interface ExtraMovieData : Mapper<Triple<String,String,String>,UiMovie> {

    abstract class Base(
        private val description: String,
        private val shortDescription: String,
        private val year: String,
    ) : ExtraMovieData {

        override fun map(mainData: Triple<String, String,String>)
            = UiMovie.Base(mainData.first,mainData.second,mainData.third,description,shortDescription, year)
    }
    class WithDescription(
        description: String,
        shortDescription: String,
        year: String
    ) : Base(description,shortDescription ,year)

    class EmptyDescription(
        description: String,
        year: String
    ) : Base(description,description,year)
}