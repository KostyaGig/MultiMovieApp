package ru.zinoview.coreuimodule

import kotlinx.coroutines.CoroutineScope

interface Dispatcher {

    fun executeBackground(scope: CoroutineScope, block: suspend () -> Unit)

    fun executeUi(scope: CoroutineScope, block: suspend () -> Unit)

    class Base(
        private val background: Work,
        private val ui: Work,
    ) : Dispatcher {
        override fun executeBackground(scope: CoroutineScope, block: suspend () -> Unit)
            = background.execute(scope, block)

        override fun executeUi(scope: CoroutineScope, block: suspend () -> Unit)
            = ui.execute(scope, block)
    }

}