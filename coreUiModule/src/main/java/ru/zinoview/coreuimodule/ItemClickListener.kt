package ru.zinoview.coreuimodule

interface ItemClickListener<T : UiModel> {

    fun onItemClick(item: T)
}