package ru.zinoview.movies.core

import ru.zinoview.core.Mapper
import ru.zinoview.movies.presentation.UiMovie

interface ExtraMovieData : Mapper<Triple<String,String,String>,UiMovie> {


    abstract class Base(
        private val description: String,
        private val year: String
    ) : ExtraMovieData {

        override fun map(mainData: Triple<String, String,String>)
            = UiMovie.Base(mainData.first,mainData.second,mainData.third,description, year)
    }
    class WithDescription(
        description: String,
        year: String
    ) : Base(description, year)

    class EmptyDescription(
        year: String
    ) : Base("",year)
}