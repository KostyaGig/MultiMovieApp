package ru.zinoview.movies.presentation

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.zinoview.core.Mapper

interface LayoutManager : Mapper<UiMovie,RecyclerView.LayoutManager>{

    class Base(
        private val context: Context
    ) : LayoutManager {

        override fun map(src: UiMovie): RecyclerView.LayoutManager {
            return when(src) {
                is UiMovie.Base -> GridLayoutManager(context,SPAN_COUNT)
                is UiMovie.Progress, is UiMovie.Failure -> LinearLayoutManager(context)
            }
        }

        private companion object {
            private const val SPAN_COUNT = 2
        }
    }
}