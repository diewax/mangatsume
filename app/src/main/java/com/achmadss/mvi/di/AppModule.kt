package com.achmadss.mvi.di

import com.achmadss.domain.repositories.manga.MangaRepository
import com.achmadss.domain.repositories.manga.MangaRepositoryImpl
import com.achmadss.mvi.base.navigation.Navigator
import com.achmadss.mvi.base.navigation.NavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    internal fun providesAppNavigator(): Navigator = NavigatorImpl()

}