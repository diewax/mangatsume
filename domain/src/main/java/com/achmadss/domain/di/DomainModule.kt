package com.achmadss.domain.di

import com.achmadss.data.local.dao.ChapterDao
import com.achmadss.data.local.dao.HistoryDao
import com.achmadss.data.local.dao.MangaDao
import com.achmadss.domain.repositories.chapter.ChapterRepository
import com.achmadss.domain.repositories.chapter.ChapterRepositoryImpl
import com.achmadss.domain.repositories.history.HistoryRepository
import com.achmadss.domain.repositories.history.HistoryRepositoryImpl
import com.achmadss.domain.repositories.manga.MangaRepository
import com.achmadss.domain.repositories.manga.MangaRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    internal fun provideMangaRepository(
        mangaDao: MangaDao,
    ): MangaRepository = MangaRepositoryImpl(mangaDao)

    @Provides
    internal fun provideChapterRepository(
        chapterDao: ChapterDao,
    ): ChapterRepository = ChapterRepositoryImpl(chapterDao)

    @Provides
    internal fun provideHistoryRepository(
        historyDao: HistoryDao,
    ): HistoryRepository = HistoryRepositoryImpl(historyDao)

}