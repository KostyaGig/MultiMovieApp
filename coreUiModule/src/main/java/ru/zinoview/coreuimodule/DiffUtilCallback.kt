package ru.zinoview.coreuimodule

import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffUtilCallback<T : UiModel, E : Same<T>> : DiffUtil.ItemCallback<E>() {

    override fun areItemsTheSame(oldItem: E, newItem: E) = oldItem.sameMain(newItem as T)
    override fun areContentsTheSame(oldItem: E, newItem: E) = oldItem.sameExtra(newItem as T)
}
