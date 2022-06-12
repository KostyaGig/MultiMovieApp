package ru.zinoview.coreuimodule

interface Same<T : UiModel> {

    fun sameMain(data: T)  : Boolean
    fun sameExtra(data: T)  : Boolean
}