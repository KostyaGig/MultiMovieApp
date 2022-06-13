package ru.zinoview.movies.presentation

import ru.zinoview.core.Screen
import ru.zinoview.core.di.Component
import ru.zinoview.movies.presentation.di.MoviesComponent

object MoviesScreen : Screen {

    override fun map(components: List<Component>) : Component {
        var foundComponent: Component = Component.Empty
        components.forEach { component ->
            if (component is MoviesComponent) {
                foundComponent = component
                return@forEach
            }
        }
        return foundComponent
    }
}