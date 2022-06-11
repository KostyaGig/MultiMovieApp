package ru.zinoview.core

interface Data <T> {

    suspend fun data() : T
}