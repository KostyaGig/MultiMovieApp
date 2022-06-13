package ru.zinoview.movies.presentation

import android.util.Log
import android.widget.TextView
import ru.zinoview.coreuimodule.Bind
import ru.zinoview.coreuimodule.Same
import ru.zinoview.coreuimodule.UiModel
import ru.zinoview.movies.core.ExtraMovieData
import ru.zinoview.movies.core.MainMovieData

sealed class UiMovie : UiModel, Same<UiMovie>, Bind<TextView>, MovieSame {

    override fun sameMain(item: UiMovie) = false
    override fun sameData(item: UiMovie) = false
    override fun sameId(id: String) = false
    override fun sameData(title: String, description: String) = false
    override fun bind(data: TextView) = Unit

    object Progress : UiMovie()

    data class Base(
        private val id: String,
        private val title: String,
        private val image: String,
        private val description: String,
        private val year: String,
    ) : UiMovie() {
        override fun sameMain(item: UiMovie)
            = item.sameId(id)

        override fun sameData(item: UiMovie) = true

        override fun sameId(id: String)
            = this.id == id

        override fun sameData(title: String, description: String)
            = this.title == title && this.description == description

        override fun bind(data: TextView) {
            data.text = title
        }
    }

    data class Failure(
        private val errorMessage: String
    ) : UiMovie() {

        override fun bind(errorMessageTextView: TextView) {
            errorMessageTextView.text = errorMessage
        }
    }


}
