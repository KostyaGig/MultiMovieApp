package ru.zinoview.movies.core

import ru.zinoview.core.Mapper
import ru.zinoview.movies.presentation.ToMovieArgumentsMapper
import ru.zinoview.movies.presentation.UiMovie

interface MainMovieData : Mapper<ExtraMovieData,UiMovie> {

    fun <T> map(extraData: ExtraMovieData,mapper: ToMovieArgumentsMapper<T>) : T

    abstract class Base(
        private val id: String,
        private val title: String,
        private val image: String
    ) : MainMovieData {

        override fun <T> map(extraData: ExtraMovieData,mapper: ToMovieArgumentsMapper<T>)
            = extraData.map(Triple(title,title,image),mapper)

        override fun map(extraData: ExtraMovieData) : UiMovie
            = extraData.map(Triple(id,title,image))
    }

    class WithImage(
        id: String,
        title: String,
        image: String
    ) : Base(id,title,image) {

    }

    class EmptyImage(
        id: String,
        title: String
    ) : Base(id,title,"")
}