package ru.zinoview.coreuimodule

interface Same<T : UiModel> {

    fun sameMain(item: T)  : Boolean
    fun sameData(item: T)  : Boolean

}