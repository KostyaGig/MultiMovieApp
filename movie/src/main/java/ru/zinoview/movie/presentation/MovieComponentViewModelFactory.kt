package ru.zinoview.movie.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

interface MovieComponentViewModelFactory : ViewModelProvider.Factory {

    class Base : MovieComponentViewModelFactory {

        override fun <T : ViewModel> create(modelClass: Class<T>)
            = MovieComponentViewModel.Base() as T
    }
}