package com.achmadss.domain.repositories.history

import com.achmadss.data.local.dao.HistoryDao
import com.achmadss.data.local.entities.History
import com.achmadss.domain.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val historyDao: HistoryDao,
): HistoryRepository {

    override suspend fun upsertHistory(
        histories: List<History>
    ) = flow<Nothing> {
        historyDao.upsertHistory(histories)
    }.flowOn(Dispatchers.IO)

    override suspend fun getAllHistory() = flow {
        emit(DataState.OnLoading)
        emit(DataState.OnData(historyDao.getAllHistory()))
    }.flowOn(Dispatchers.IO).catch {
        emit(DataState.OnFailure(it))
    }

    override suspend fun deleteHistory(
        history: History
    ) = flow<Nothing> {
        historyDao.deleteHistory(history)
    }

    override suspend fun deleteHistoryForChapter(
        chapterId: Long
    ) = flow<Nothing> {
        historyDao.deleteHistoryForChapter(chapterId)
    }

}