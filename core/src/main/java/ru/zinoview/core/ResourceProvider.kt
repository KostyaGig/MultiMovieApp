package ru.zinoview.core

import android.content.Context
import androidx.annotation.StringRes
import ru.zinoview.R

interface ResourceProvider {

    fun string(@StringRes id: Int) : String

    class Base(
        private val context: Context
    ) : ResourceProvider {
        override fun string(id: Int) = context.getString(id)
    }

    class Test : ResourceProvider {

        override fun string(id: Int): String {
            return when(id){
                R.string.no_connection_error_text -> "No connection"
                R.string.progress_text -> "Progress"
                R.string.something_went_wrong_text -> "Something went wrong"
                else -> throw IllegalArgumentException("String by $id wasn't found")
            }
        }
    }
}