package ru.zinoview.multimovieapp

import android.app.Application
import androidx.lifecycle.*
import ru.zinoview.core.ResourceProvider
import ru.zinoview.core.cloud.NetworkServiceProvider
import ru.zinoview.movies.data.MoviesRepository
import ru.zinoview.movies.data.ToMovieMapper
import ru.zinoview.movies.data.cloud.MoviesCloudDataSource
import ru.zinoview.movies.data.cloud.ToCloudMovieMapper
import ru.zinoview.movies.domain.DataToDomainExceptionMapper
import ru.zinoview.movies.domain.DataToDomainMoviesMapper
import ru.zinoview.movies.domain.MoviesInteractor
import ru.zinoview.movies.presentation.MoviesViewModel
import ru.zinoview.movies.presentation.MoviesViewModelFactory

class MovieApp : Application() {

    private lateinit var factory: MoviesViewModelFactory

    override fun onCreate() {
        super.onCreate()
        val resourceProvider = ResourceProvider.Base(this)
        val networkProvider = NetworkServiceProvider.Base()

        val interactor = MoviesInteractor.Base(
            MoviesRepository.Base(
                MoviesCloudDataSource.Base(
                    networkProvider,ToCloudMovieMapper.Base()
                ),
                ToMovieMapper.Base()
            ),
            DataToDomainMoviesMapper.Base(DataToDomainExceptionMapper.Base())
        )

        factory = MoviesViewModelFactory.Base(interactor, resourceProvider)

    }

    fun viewModel(owner: ViewModelStoreOwner) : MoviesViewModel
        = ViewModelProvider(owner,factory)[MoviesViewModel.Base::class.java]

}