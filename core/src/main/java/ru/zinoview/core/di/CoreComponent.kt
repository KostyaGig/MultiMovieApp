package ru.zinoview.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.zinoview.core.di.cloud.NetworkModule
import javax.inject.Singleton

@Component(modules = [CoreModule::class,NetworkModule::class])
@Singleton
interface CoreComponent {

    @Component.Builder
    interface Builder {

        fun build() : CoreComponent

        @BindsInstance
        fun bindContext(context: Context) : Builder
    }
}