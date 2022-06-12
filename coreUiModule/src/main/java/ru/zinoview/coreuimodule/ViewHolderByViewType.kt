package ru.zinoview.coreuimodule

import android.view.LayoutInflater
import android.view.ViewGroup

interface ViewHolderByViewType<T : UiModel> {

    fun viewType(item: T): Int
    fun viewHolder(viewType: Int, inflater: LayoutInflater, parent: ViewGroup): BaseViewHolder<T>
}