package ru.zinoview.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import ru.zinoview.core.ResourceProvider
import ru.zinoview.coreuimodule.*
import ru.zinoview.movies.domain.MoviesInteractor
import java.lang.IllegalStateException

interface MoviesViewModelFactory : ViewModelProvider.Factory {

    class Base(
        private val interactor: MoviesInteractor,
        private val resourceProvider: ResourceProvider
    ) : MoviesViewModelFactory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T = MoviesViewModel.Base(
            interactor,DomainToUiMoviesMapper.Base(DomainToUiMovieMapper.Base(),DomainExceptionToUiStringMapper.Base(resourceProvider)),
            DispatcherWork.Base(
                Dispatcher.Base(
                    Work.Base(),
                    Work.Base(Dispatchers.Main)
                )
            ),UiMoviesCommunication.Base()
        ) as T
    }

    object Empty : MoviesViewModelFactory {
        override fun <T : ViewModel> create(modelClass: Class<T>)
            = throw IllegalStateException("MoviesViewModelFactory.Empty -> create()")
    }

}