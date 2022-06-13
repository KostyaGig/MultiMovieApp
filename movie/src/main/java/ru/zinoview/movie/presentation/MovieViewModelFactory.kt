package ru.zinoview.movie.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

interface MovieViewModelFactory : ViewModelProvider.Factory {

    class Base : MovieViewModelFactory {

        override fun <T : ViewModel> create(modelClass: Class<T>)
            = MovieViewModel.Base(UiDetailMovieCommunication.Base()) as T
    }
}