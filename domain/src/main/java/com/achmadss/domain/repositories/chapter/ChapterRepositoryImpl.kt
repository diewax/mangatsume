package com.achmadss.domain.repositories.chapter

import com.achmadss.domain.DataState
import com.achmadss.data.local.dao.ChapterDao
import com.achmadss.data.local.entities.Chapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ChapterRepositoryImpl @Inject constructor(
    private val chapterDao: ChapterDao,
): ChapterRepository {

    override suspend fun upsertChapters(
        chapters: List<Chapter>
    ) = flow<Nothing> {
        chapterDao.upsertChapter(chapters)
    }.flowOn(Dispatchers.IO)

    override suspend fun getChapterById(
        chapterId: Long
    ) = flow {
        emit(DataState.OnLoading)
        val data = chapterDao.getChapterById(chapterId) ?: throw Exception("Chapter not found")
        emit(DataState.OnData(data))
    }.flowOn(Dispatchers.IO).catch {
        emit(DataState.OnFailure(it))
    }

    override suspend fun markChapterAsRead(
        chapterId: Long,
        isRead: Boolean
    ) = flow<Nothing> {
        chapterDao.markChapterAsRead(chapterId, isRead)
    }.flowOn(Dispatchers.IO)

    override suspend fun deleteChapter(
        chapter: Chapter
    ) = flow<Nothing> {
        chapterDao.deleteChapter(chapter)
    }.flowOn(Dispatchers.IO)

}