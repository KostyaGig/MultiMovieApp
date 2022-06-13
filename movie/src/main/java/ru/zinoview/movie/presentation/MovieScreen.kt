package ru.zinoview.movie.presentation

import ru.zinoview.core.Screen
import ru.zinoview.core.di.Component
import ru.zinoview.movie.presentation.di.MovieComponent

object MovieScreen : Screen {

    override fun map(components: List<Component>) : Component {
        var foundComponent: Component = Component.Empty
        components.forEach { component ->
            if (component is MovieComponent) {
                foundComponent = component
                return@forEach
            }
        }
        return foundComponent
    }
}