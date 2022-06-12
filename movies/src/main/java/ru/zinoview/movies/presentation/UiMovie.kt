package ru.zinoview.movies.presentation

import ru.zinoview.movies.core.ExtraMovieData
import ru.zinoview.movies.core.MainMovieData

sealed class UiMovie {

    data class Base(
        private val mainData: MainMovieData,
        private val extraData: ExtraMovieData
    ) : UiMovie()

    data class Failure(
        private val errorMessage: String
    ) : UiMovie()


}
