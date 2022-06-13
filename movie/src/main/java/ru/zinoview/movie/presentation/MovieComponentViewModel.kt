package ru.zinoview.movie.presentation

import androidx.lifecycle.ViewModel
import ru.zinoview.core.Mapper
import ru.zinoview.coreuimodule.BaseViewModel
import ru.zinoview.coreuimodule.Observe
import ru.zinoview.movie.presentation.di.MovieComponent

interface MovieComponentViewModel  {

    fun movieViewModelFactory(component: MovieComponent): MovieViewModelFactory

    class Base : MovieComponentViewModel,ViewModel() {

        override fun movieViewModelFactory(component: MovieComponent)
            = component.movieViewModelFactory()
    }
}