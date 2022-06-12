package ru.zinoview.coreuimodule

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T : UiModel>(
    view: View
) : RecyclerView.ViewHolder(view), Bind<T> {
    override fun bind(data: T) = Unit
}