package ru.zinoview.movies.presentation

import ru.zinoview.coremoviemodule.UiDetailBundle
import ru.zinoview.coremoviemodule.UiDetailBundleWrapper
import ru.zinoview.coreuimodule.ItemClickListener
import ru.zinoview.navigation.Navigation

interface UiMovieItemClickListener : ItemClickListener<UiMovie> {

    override fun onItemClick(item: UiMovie) = Unit

    class Base(
        private val navigation: Navigation,
        private val mapper: ToDetailMovieMapper,
        private val bundle: UiDetailBundle
    ) : UiMovieItemClickListener {

        override fun onItemClick(item: UiMovie) {
            val uiDetailMovie = item.map(mapper)
            val bundle = bundle.bundle(uiDetailMovie)
            navigation.navigate(UiDetailBundleWrapper.Base(bundle), ru.zinoview.navigation.R.id.action_moviesFragment_to_movieFragment)
        }
    }
    object Empty : UiMovieItemClickListener
}