package ru.zinoview.coremoviemodule

interface UiDetailBundle : ru.zinoview.coreuimodule.Bundle<UiDetailMovie> {

    class Base(
        bundleWrapper: UiDetailBundleWrapper = UiDetailBundleWrapper.Empty
    ) : UiDetailBundle, ru.zinoview.coreuimodule.Bundle.Base<UiDetailMovie>(bundleWrapper,KEY) {

        private companion object {
            private const val KEY = "uiDetailMovie"
        }
    }
}