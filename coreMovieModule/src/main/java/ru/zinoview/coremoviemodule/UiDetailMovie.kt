package ru.zinoview.coremoviemodule

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import ru.zinoview.coreuimodule.Bind
import ru.zinoview.coreuimodule.UiModel

interface UiDetailMovie : UiModel, Parcelable, Bind<Pair<List<TextMovieViewWrapper>,ImageMovieViewWrapper>> {

    override fun bind(data: Pair<List<TextMovieViewWrapper>, ImageMovieViewWrapper>) = Unit

    @Parcelize
    data class Base(
        private val title: String,
        private val description: String,
        private val url: String
    ) : UiDetailMovie {

        override fun bind(data: Pair<List<TextMovieViewWrapper>, ImageMovieViewWrapper>) {
            val texts = data.first
            val image = data.second
            texts.forEach { text -> text.show(Pair(title,description))}
            image.show(url)
        }
    }

    @Parcelize
    object Empty : UiDetailMovie
}