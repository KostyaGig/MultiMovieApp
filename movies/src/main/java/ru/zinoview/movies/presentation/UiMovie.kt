package ru.zinoview.movies.presentation

import android.util.Log
import android.widget.TextView
import ru.zinoview.coreuimodule.Bind
import ru.zinoview.coreuimodule.Same
import ru.zinoview.coreuimodule.UiModel
import ru.zinoview.coreuimodule.ViewWrapper

sealed class UiMovie : UiModel, Same<UiMovie>, Bind<Pair<List<TextViewWrapper>,ImageViewWrapper>>, MovieSame {

    override fun sameMain(item: UiMovie) = false
    override fun sameData(item: UiMovie) = false
    override fun sameId(id: String) = false
    override fun sameData(title: String, description: String) = false

    override fun bind(data: Pair<List<TextViewWrapper>, ImageViewWrapper>) = Unit

    object Progress : UiMovie()

    data class Base(
        private val id: String,
        private val title: String,
        private val url: String,
        private val description: String,
        private val shortDescription: String,
        private val year: String,
    ) : UiMovie() {
        override fun sameMain(item: UiMovie)
            = item.sameId(id)

        override fun sameData(item: UiMovie) = true

        override fun sameId(id: String)
            = this.id == id

        override fun sameData(title: String, description: String)
            = this.title == title && this.description == description

        override fun bind(data: Pair<List<TextViewWrapper>, ImageViewWrapper>) {
            val texts = data.first
            val image = data.second
            texts.forEach { text -> text.show(Pair(title,shortDescription)) }
            image.show(url)
        }
    }

    data class Failure(
        private val errorMessage: String
    ) : UiMovie() {

        override fun bind(data: Pair<List<TextViewWrapper>, ImageViewWrapper>) {
            val errorTextView = data.first.first()
            errorTextView.show(Pair(errorMessage,errorMessage))
        }
    }


}
