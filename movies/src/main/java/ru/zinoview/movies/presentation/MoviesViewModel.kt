package ru.zinoview.movies.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import ru.zinoview.coreuimodule.BaseViewModel
import ru.zinoview.coreuimodule.DispatcherWork
import ru.zinoview.coreuimodule.Observe
import ru.zinoview.movies.domain.MoviesInteractor

interface MoviesViewModel : Observe<UiMovies>{

    fun movies()

    class Base(
        private val interactor: MoviesInteractor,
        private val mapper: DomainToUiMoviesMapper,
        private val work: DispatcherWork,
        private val communication: UiMoviesCommunication
    ) : MoviesViewModel, BaseViewModel.Base<UiMovies>(communication) {

        override fun movies() {
            work.execute(viewModelScope,{
                interactor.data().map(mapper)
            },{ uiMovies ->
                communication.map(UiMovies.Base(uiMovies))
            })
        }
    }
}