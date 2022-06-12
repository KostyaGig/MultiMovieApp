package ru.zinoview.coreuimodule

interface Same<T : UiModel> {

    fun sameMain(item: T)  : Boolean
    fun sameExtra(item: T)  : Boolean
}