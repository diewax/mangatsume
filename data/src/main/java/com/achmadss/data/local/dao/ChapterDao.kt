package com.achmadss.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.achmadss.data.local.entities.Chapter

@Dao
interface ChapterDao {
    @Upsert
    suspend fun upsertChapter(chapters: List<Chapter>)

    @Query("SELECT * FROM chapters WHERE chapterId = :chapterId")
    suspend fun getChapterById(chapterId: Long): Chapter?

    @Query("UPDATE chapters SET isRead = :isRead WHERE chapterId = :chapterId")
    suspend fun markChapterAsRead(chapterId: Long, isRead: Boolean)

    @Delete
    suspend fun deleteChapter(chapter: Chapter)
}
