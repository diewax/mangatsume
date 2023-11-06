package com.achmadss.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.achmadss.data.local.entities.History

@Dao
interface HistoryDao {
    @Upsert
    suspend fun upsertHistory(histories: List<History>)

    @Query("SELECT * FROM history ORDER BY dateTime DESC")
    suspend fun getAllHistory(): List<History>

    @Delete
    suspend fun deleteHistory(history: History)

    @Query("DELETE FROM history WHERE chapterId = :chapterId")
    suspend fun deleteHistoryForChapter(chapterId: Long)
}
