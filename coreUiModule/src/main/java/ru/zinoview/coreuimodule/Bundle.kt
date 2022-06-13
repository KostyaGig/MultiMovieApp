package ru.zinoview.coreuimodule

import android.os.Bundle
import android.os.Parcelable
import ru.zinoview.core.Read
import java.lang.IllegalStateException

interface Bundle<T : Parcelable> : Read<T> {

    override fun read(): T = throw IllegalStateException("Bundle.save()")
    fun bundle(data: T) : Bundle

    abstract class Base<T : Parcelable>(
        private val bundleWrapper: BundleWrapper<T>,
        private val key: String
    ) : ru.zinoview.coreuimodule.Bundle<T> {

        override fun read(): T = bundleWrapper.bundle(key)

        override fun bundle(data: T): Bundle = Bundle().apply {
            putParcelable(key,data)
        }
    }
}