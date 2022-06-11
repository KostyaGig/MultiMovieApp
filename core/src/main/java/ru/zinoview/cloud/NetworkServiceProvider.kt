package ru.zinoview.cloud

interface NetworkServiceProvider {

    fun <T : Any> service(clazz: Class<T>) : T

    class Base(
    ) : NetworkServiceProvider {
        private var wrapper: RetrofitWrapper = RetrofitWrapper.Empty

        override fun <T : Any> service(clazz: Class<T>) : T {
            wrapper = wrapper.retrofit()
            return wrapper.service(clazz)
        }

    }
}