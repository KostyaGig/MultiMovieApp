package ru.zinoview.navigation

import ru.zinoview.coreuimodule.BundleWrapper

interface Navigation {

    fun navigate(bundle: BundleWrapper<*> = BundleWrapper.Empty, actionId: Int = -1)
}