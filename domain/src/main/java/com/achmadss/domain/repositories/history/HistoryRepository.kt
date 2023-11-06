package com.achmadss.domain.repositories.history

import com.achmadss.data.local.entities.History
import com.achmadss.domain.DataState
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    suspend fun upsertHistory(histories: List<History>): Flow<Nothing>
    suspend fun getAllHistory(): Flow<DataState<List<History>>>
    suspend fun deleteHistory(history: History): Flow<Nothing>
    suspend fun deleteHistoryForChapter(chapterId: Long): Flow<Nothing>

}