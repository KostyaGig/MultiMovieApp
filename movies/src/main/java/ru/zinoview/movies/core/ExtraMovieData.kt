package ru.zinoview.movies.core

import ru.zinoview.core.Mapper
import ru.zinoview.movies.data.ToMovieMapper
import ru.zinoview.movies.presentation.ToMovieArgumentsMapper
import ru.zinoview.movies.presentation.UiMovie

interface ExtraMovieData: Mapper<Triple<String,String,String>,UiMovie> {

    fun <T> map(mainData: Triple<String, String, String>,mapper: ToMovieArgumentsMapper<T>) : T

    abstract class Base(
        private val description: String,
        private val shortDescription: String,
        private val year: String,
    ) : ExtraMovieData {

        override fun <T> map(
            mainData: Triple<String, String, String>,
            mapper: ToMovieArgumentsMapper<T>
        ) = mapper.map(mainData.first,description,mainData.third)

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