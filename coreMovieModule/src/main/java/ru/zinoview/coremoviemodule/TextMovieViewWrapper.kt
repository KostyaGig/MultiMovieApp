package ru.zinoview.coremoviemodule

import android.widget.TextView
import ru.zinoview.coreuimodule.ViewWrapper

interface TextMovieViewWrapper : ViewWrapper<Pair<String, String>> {


    class Title(
        private val textView: TextView
    ) : TextMovieViewWrapper {
        override fun show(data: Pair<String, String>) {
            textView.text = data.first
        }

    }

    class Description(
        private val textView: TextView
    ) : TextMovieViewWrapper {

        override fun show(data: Pair<String, String>) {
            textView.text = data.second
        }
    }

    class Error(
        private val textView: TextView
    ) : TextMovieViewWrapper {
        override fun show(data: Pair<String, String>) {
            textView.text = data.first
        }
    }
}