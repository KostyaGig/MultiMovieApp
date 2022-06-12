package ru.zinoview.di

import android.content.Context
import dagger.Binds
import dagger.Module
import ru.zinoview.ResourceProvider
import javax.inject.Singleton

@Module
interface CoreModule {

    @Binds
    @Singleton
    fun provideResourceProvider(context: Context): ResourceProvider
}