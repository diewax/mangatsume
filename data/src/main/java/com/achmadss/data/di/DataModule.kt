package com.achmadss.data.di

import android.content.Context
import com.achmadss.data.local.database.LocalDataSource
import com.achmadss.data.provider.DataProvider
import com.achmadss.data.remote.RemoteDataSource
import com.achmadss.data.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    internal fun provideRemoteDataSource(): RemoteDataSource = DataProvider.initializeRemoteDataSource(BuildConfig.BASE_URL)

    @Provides
    internal fun provideLocalDataSource(
        @ApplicationContext context: Context,
    ): LocalDataSource = DataProvider.initializeLocalDataSource(context)

    @Provides
    internal fun provideMangaDao(db: LocalDataSource) = db.mangaDao()

    @Provides
    internal fun provideChapterDao(db: LocalDataSource) = db.chapterDao()

    @Provides
    internal fun provideHistoryDao(db: LocalDataSource) = db.historyDao()

}