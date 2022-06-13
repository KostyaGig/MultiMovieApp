package ru.zinoview.movie.presentation


interface UiDetailBundle : ru.zinoview.coreuimodule.Bundle<UiDetailMovie> {

    class Base(
        bundleWrapper: UiDetailBundleWrapper
    ) : UiDetailBundle, ru.zinoview.coreuimodule.Bundle.Base<UiDetailMovie>(bundleWrapper,KEY) {

        private companion object {
            private const val KEY = "uiDetailMovie"
        }
    }
}