package ru.zinoview.movies.presentation

import ru.zinoview.movies.core.ExtraMovieData
import ru.zinoview.movies.core.MainMovieData

sealed class UiMovie {

    class Base(
        private val mainData: MainMovieData,
        private val extraData: ExtraMovieData
    ) : UiMovie()

    class Failure(
        private val errorMessage: String
    ) : UiMovie()


}
