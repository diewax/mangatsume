package com.achmadss.data.di

import android.content.Context
import androidx.room.Room
import com.achmadss.data.local.database.MangatsumeDatabase
import com.achmadss.data.provider.DataProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    internal fun provideMangatsumeDatabase(
        @ApplicationContext context: Context,
    ): MangatsumeDatabase = DataProvider.initializeDatabase(context)

    @Provides
    internal fun provideMangaDao(db: MangatsumeDatabase) = db.mangaDao()

    @Provides
    internal fun provideChapterDao(db: MangatsumeDatabase) = db.chapterDao()

    @Provides
    internal fun provideHistoryDao(db: MangatsumeDatabase) = db.historyDao()

}