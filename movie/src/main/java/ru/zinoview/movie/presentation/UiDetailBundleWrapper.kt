package ru.zinoview.movie.presentation

import android.os.Bundle
import android.os.Parcelable
import ru.zinoview.core.Read
import ru.zinoview.coreuimodule.BundleWrapper
import java.lang.IllegalStateException

interface UiDetailBundleWrapper : BundleWrapper<UiDetailMovie> {

    class Base(
        bundle: Bundle
    ) : UiDetailBundleWrapper, BundleWrapper.Base<UiDetailMovie>(bundle)
}