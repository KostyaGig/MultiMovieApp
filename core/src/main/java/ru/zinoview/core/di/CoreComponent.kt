package ru.zinoview.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface CoreComponent {

    @Component.Builder
    interface Builder {

        fun build() : CoreComponent

        @BindsInstance
        fun bindContext(context: Context) : Builder
    }
}