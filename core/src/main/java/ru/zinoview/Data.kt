package ru.zinoview

interface Data <T> {

    suspend fun data() : T
}