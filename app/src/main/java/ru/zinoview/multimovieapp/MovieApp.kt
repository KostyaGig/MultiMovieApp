package ru.zinoview.multimovieapp

import android.app.Application
import androidx.lifecycle.*
import ru.zinoview.core.di.CoreComponent
import ru.zinoview.core.di.DaggerCoreComponent
import ru.zinoview.movies.presentation.MoviesViewModel
import ru.zinoview.movies.presentation.MoviesViewModelFactory
import ru.zinoview.multimovieapp.di.DaggerMoviesComponent
import ru.zinoview.multimovieapp.di.MoviesComponent

class MovieApp : Application() {

    private lateinit var factory: MoviesViewModelFactory
    lateinit var coreComponent: CoreComponent
    lateinit var moviesComponent: MoviesComponent

    override fun onCreate() {
        super.onCreate()

        coreComponent = DaggerCoreComponent.builder().bindContext(this).build()
        moviesComponent = DaggerMoviesComponent.builder().coreComponent(coreComponent).build()

//        val resourceProvider = ResourceProvider.Base(this)
//
//        val interactor = MoviesInteractor.Base(
//            MoviesRepository.Base(
//                MoviesCloudDataSource.Base(
//                    networkProvider,ToCloudMovieMapper.Base()
//                ),
//                ToMovieMapper.Base()
//            ),
//            DataToDomainMoviesMapper.Base(DataToDomainExceptionMapper.Base())
//        )
//
//        val delayInteractor  = MoviesInteractor.Delay(3000,interactor)
//
//        factory = MoviesViewModelFactory.Base(delayInteractor, resourceProvider)

    }

    fun viewModel(owner: ViewModelStoreOwner) : MoviesViewModel
        = ViewModelProvider(owner,factory)[MoviesViewModel.Base::class.java]

}