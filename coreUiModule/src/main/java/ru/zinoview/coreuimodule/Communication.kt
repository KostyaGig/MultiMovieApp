package ru.zinoview.coreuimodule

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import ru.zinoview.core.Mapper

interface Communication<T : UiModel> : Observe<T>, Mapper<T,Unit> {

    abstract class Base<T : UiModel> : Communication<T> {

        private val liveData = MutableLiveData<T>()

        override fun observe(owner: LifecycleOwner, observer: Observer<T>)
            = liveData.observe(owner, observer)

        override fun map(value: T) {
            liveData.value = value
        }

    }
}