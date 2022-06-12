package ru.zinoview.movies.presentation

import android.widget.TextView
import ru.zinoview.coreuimodule.Bind
import ru.zinoview.coreuimodule.Same
import ru.zinoview.coreuimodule.UiModel
import ru.zinoview.movies.core.ExtraMovieData
import ru.zinoview.movies.core.MainMovieData

sealed class UiMovie : UiModel, Same<UiMovie>, Bind<TextView>, MovieSame {

    override fun sameMain(data: UiMovie) = false
    override fun sameExtra(data: UiMovie) = false
    override fun sameId(id: String) = false
    override fun sameData(description: String) = false
    
    override fun bind(data: TextView) = Unit

    object Progress : UiMovie()

    data class Base(
        private val mainData: MainMovieData,
        private val extraData: ExtraMovieData
    ) : UiMovie() {

        // todo add implementation for these methods
        override fun sameMain(item: UiMovie)
            = TODO()

        override fun sameExtra(item: UiMovie)
            = TODO()

        override fun bind(titleMovieTextView: TextView)
            = mainData.bind(titleMovieTextView)

        override fun sameId(id: String)
            = mainData.sameData(id)

        override fun sameData(description: String)
            = extraData.sameData(description)
    }

    data class Failure(
        private val errorMessage: String
    ) : UiMovie() {

        override fun bind(errorMessageTextView: TextView) {
            errorMessageTextView.text = errorMessage
        }
    }


}
