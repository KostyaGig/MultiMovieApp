package ru.zinoview.movies.core

import android.widget.TextView
import ru.zinoview.coreuimodule.Bind
import ru.zinoview.movies.presentation.MovieSame

interface MainMovieData : Bind<TextView>, MovieSame {

    override fun sameData(description: String) = false

    abstract class Base(
        private val id: String,
        private val title: String
    ) : MainMovieData {
        override fun bind(text: TextView) {
            text.text = title
        }

        override fun sameId(id: String)
            = this.id == id
    }

    class WithImage(
        private val id: String,
        private val image: String,
        title: String
    ) : Base(id,title) {

        override fun sameId(id: String) = this.id == id
    }

    class EmptyImage(
        private val id: String,
        title: String
    ) : Base(id,title)
}