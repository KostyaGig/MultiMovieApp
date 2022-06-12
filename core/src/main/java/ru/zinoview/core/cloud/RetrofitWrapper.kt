package ru.zinoview.core.cloud

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.IllegalStateException

interface RetrofitWrapper {

    fun <T : Any> service(clazz: Class<T>) : T

    fun retrofit() : RetrofitWrapper

    class Base : RetrofitWrapper {

        private var retrofit:Retrofit? = null

        // todo
        @Synchronized
        override fun <T : Any> service(clazz: Class<T>): T {
            if (retrofit == null) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

                val client = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

                retrofit = Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit?.create(clazz)!!
        }

        private companion object {
            private const val BASE_URL = "https://s3-eu-west-1.amazonaws.com/"
        }

        override fun retrofit() = this
    }

    object Empty : RetrofitWrapper {
        override fun <T : Any> service(clazz: Class<T>)
            = throw IllegalStateException("RetrofitWrapper.Empty can't provide service $clazz")
        override fun retrofit()  = Base()
    }
}