package ru.zinoview.core

import ru.zinoview.core.di.Component

interface MovieApplication {

    fun component(screen: Screen) : Component
}