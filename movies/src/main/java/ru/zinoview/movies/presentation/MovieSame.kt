package ru.zinoview.movies.presentation


interface MovieSame {

    fun sameId(id: String) : Boolean
    fun sameData(description: String) : Boolean
}