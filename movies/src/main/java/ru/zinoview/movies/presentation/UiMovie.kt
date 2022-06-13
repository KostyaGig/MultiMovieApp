package ru.zinoview.movies.presentation

import ru.zinoview.coremoviemodule.ImageMovieViewWrapper
import ru.zinoview.coremoviemodule.TextMovieViewWrapper
import ru.zinoview.coreuimodule.Bind
import ru.zinoview.coreuimodule.Same
import ru.zinoview.coreuimodule.UiModel
import ru.zinoview.movies.core.BaseMovie
import ru.zinoview.movies.core.ExtraMovieData
import ru.zinoview.movies.core.MainMovieData
import ru.zinoview.movies.core.MovieMapper

sealed class UiMovie : UiModel, Same<UiMovie>, Bind<Pair<List<TextMovieViewWrapper>,ImageMovieViewWrapper>>, MovieSame, BaseMovie {

    override fun sameMain(item: UiMovie) = false
    override fun sameData(item: UiMovie) = false
    override fun sameId(id: String) = false
    override fun sameData(title: String, description: String) = false

    override fun bind(data: Pair<List<TextMovieViewWrapper>, ImageMovieViewWrapper>) = Unit

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

        override fun bind(data: Pair<List<TextMovieViewWrapper>, ImageMovieViewWrapper>) {
            val texts = data.first
            val image = data.second
            texts.forEach { text -> text.show(Pair(title,shortDescription)) }
            image.show(url)
        }

        override fun <T> map(mapper: MovieMapper<T>)
            = mapper.map(MainMovieData.WithImage(id,title,url),ExtraMovieData.WithDescription(description, shortDescription, year))
    }

    data class Failure(
        private val errorMessage: String
    ) : UiMovie() {

        override fun bind(data: Pair<List<TextMovieViewWrapper>, ImageMovieViewWrapper>) {
            val errorTextView = data.first.first()
            errorTextView.show(Pair(errorMessage,errorMessage))
        }
    }


}
