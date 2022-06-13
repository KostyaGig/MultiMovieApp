package ru.zinoview.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

interface MoviesComponentViewModelFactory : ViewModelProvider.Factory {

    class Base : MoviesComponentViewModelFactory {

        override fun <T : ViewModel> create(modelClass: Class<T>)
            = MoviesComponentViewModel.Base() as T

    }
}