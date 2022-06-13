package ru.zinoview.coreuimodule

import android.graphics.ParcelableColorSpace
import android.os.Bundle
import android.os.Parcelable
import java.lang.IllegalStateException

interface BundleWrapper<T : Parcelable> {

    fun bundle(key: String) : T = throw IllegalStateException("BundleWrapper.bundle()")

    abstract class Base<T : Parcelable>(
        private val bundle: Bundle
    ) : BundleWrapper<T> {

        override fun bundle(key: String): T = bundle.getParcelable(key)!!
    }

    object Empty : BundleWrapper<ParcelableColorSpace>
}