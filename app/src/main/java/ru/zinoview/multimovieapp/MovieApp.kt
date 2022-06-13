package ru.zinoview.multimovieapp

import android.app.Application
import ru.zinoview.core.MovieApplication
import ru.zinoview.core.Screen
import ru.zinoview.core.di.Component
import ru.zinoview.core.di.CoreComponent
import ru.zinoview.core.di.DaggerCoreComponent
import ru.zinoview.movies.presentation.di.DaggerMoviesComponent
import ru.zinoview.movies.presentation.di.MoviesComponent

class MovieApp : Application() , MovieApplication {

    private lateinit var coreComponent: CoreComponent
    lateinit var moviesComponent: MoviesComponent

    override fun onCreate() {
        super.onCreate()

        coreComponent = DaggerCoreComponent.builder().bindContext(this).build()
        moviesComponent = DaggerMoviesComponent.builder().coreComponent(coreComponent).build()
    }

    override fun component(screen: Screen)
        = screen.map(listOf(moviesComponent))

}