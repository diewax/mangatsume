package com.achmadss.domain.repositories.chapter

import com.achmadss.domain.DataState
import com.achmadss.data.local.entities.Chapter
import kotlinx.coroutines.flow.Flow

interface ChapterRepository {

    suspend fun upsertChapters(chapters: List<Chapter>): Flow<Nothing>
    suspend fun getChapterById(chapterId: Long): Flow<DataState<Chapter>>
    suspend fun markChapterAsRead(chapterId: Long, isRead: Boolean): Flow<Nothing>
    suspend fun deleteChapter(chapter: Chapter): Flow<Nothing>

}