package ru.zinoview.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import ru.zinoview.core.ResourceProvider
import ru.zinoview.core.di.cloud.NetworkModule
import javax.inject.Singleton

@Component(modules = [CoreModule::class,NetworkModule::class])
interface CoreComponent {

    fun resourceProvider() : ResourceProvider
    fun retrofit() : Retrofit

    @Component.Builder
    interface Builder {

        fun build() : CoreComponent

        @BindsInstance
        fun bindContext(context: Context) : Builder
    }
}