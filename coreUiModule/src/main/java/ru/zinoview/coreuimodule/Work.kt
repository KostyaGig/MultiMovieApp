package ru.zinoview.coreuimodule

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

interface Work {

    fun execute(scope: CoroutineScope,block: suspend () -> Unit)

    class Base(
        private val dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) : Work {

        override fun execute(scope: CoroutineScope, block: suspend () -> Unit) {
            scope.launch(dispatcher) { block.invoke() }
        }
    }
}