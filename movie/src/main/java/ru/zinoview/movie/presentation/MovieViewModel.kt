package ru.zinoview.movie.presentation

import ru.zinoview.core.Mapper
import ru.zinoview.coreuimodule.BaseViewModel
import ru.zinoview.coreuimodule.Observe

interface MovieViewModel : Mapper<UiDetailMovie,Unit>, Observe<UiDetailMovie> {

    class Base(
        private val communication: UiDetailMovieCommunication
    ) : MovieViewModel,BaseViewModel.Base<UiDetailMovie>(communication) {

        override fun map(movie: UiDetailMovie) = communication.map(movie)
    }
}