package ru.zinoview.coreuimodule

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

interface BaseViewModel<T : UiModel> : Observe<T> {

    class Base<T : UiModel>(
        private val communication: Communication<T>
    ) : BaseViewModel<T>, ViewModel() {

        override fun observe(owner: LifecycleOwner, observer: Observer<T>)
            = communication.observe(owner, observer)
    }
}