package ru.zinoview.coremoviemodule

import android.os.Bundle
import ru.zinoview.coreuimodule.BundleWrapper

interface UiDetailBundleWrapper : BundleWrapper<UiDetailMovie> {

    class Base(
        bundle: Bundle
    ) : UiDetailBundleWrapper, BundleWrapper.Base<UiDetailMovie>(bundle)

    object Empty : UiDetailBundleWrapper
}