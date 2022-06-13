package ru.zinoview.movies.presentation

import android.widget.TextView
import ru.zinoview.coreuimodule.ViewWrapper

interface TextViewWrapper : ViewWrapper<Pair<String,String>> {


    class Title(
        private val textView: TextView
    ) : TextViewWrapper {
        override fun show(data: Pair<String, String>) {
            textView.text = data.first
        }

    }

    class Description(
        private val textView: TextView
    ) : TextViewWrapper {

        override fun show(data: Pair<String, String>) {
            textView.text = data.second
        }
    }

    class Error(
        private val textView: TextView
    ) : TextViewWrapper {
        override fun show(data: Pair<String, String>) {
            textView.text = data.first
        }
    }
}