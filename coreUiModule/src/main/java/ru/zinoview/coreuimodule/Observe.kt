package ru.zinoview.coreuimodule

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface Observe<T : UiModel> {
    fun observe(owner: LifecycleOwner,observer: Observer<T>)
}