package ru.zinoview.movie.presentation

import ru.zinoview.coremoviemodule.UiDetailMovie
import ru.zinoview.coreuimodule.Communication

interface UiDetailMovieCommunication : Communication<UiDetailMovie> {

    class Base : UiDetailMovieCommunication,Communication.Base<UiDetailMovie>()
}