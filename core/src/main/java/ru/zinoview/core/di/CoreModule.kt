package ru.zinoview.core.di

import dagger.Binds
import dagger.Module
import ru.zinoview.core.ResourceProvider
import javax.inject.Singleton

@Module
interface CoreModule {

    @Binds
    fun provideResourceProvider(resourceProvider: ResourceProvider.Base): ResourceProvider
}