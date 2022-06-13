package ru.zinoview.movie.presentation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import ru.zinoview.coreuimodule.UiModel

interface UiDetailMovie : UiModel, Parcelable {

    @Parcelize
    data class Base(
        private val title: String,
        private val description: String,
        private val url: String
    ) : UiDetailMovie

    @Parcelize
    object Empty : UiDetailMovie
}