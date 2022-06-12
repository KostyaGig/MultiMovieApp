package ru.zinoview.coreuimodule

import kotlinx.coroutines.CoroutineScope

interface DispatcherWork {

    fun <T> execute(scope: CoroutineScope, background: suspend () -> T, ui: suspend (T) -> Unit)

    class Base(
        private val dispatcher: Dispatcher
    ) : DispatcherWork {

        override fun <T> execute(
            scope: CoroutineScope,
            background: suspend () -> T,
            ui: suspend (T) -> Unit
        ) = dispatcher.executeBackground(scope) {
            val backgroundData = background.invoke()
            dispatcher.executeUi(scope) { ui.invoke(backgroundData) }
        }
    }

}