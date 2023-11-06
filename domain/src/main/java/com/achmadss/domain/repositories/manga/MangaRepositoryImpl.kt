package com.achmadss.domain.repositories.manga

import com.achmadss.data.local.dao.MangaDao
import com.achmadss.data.local.entities.Manga
import com.achmadss.domain.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MangaRepositoryImpl @Inject constructor(
    private val mangaDao: MangaDao,
): MangaRepository {

    override suspend fun upsertManga(
        mangas: List<Manga>
    ) = flow<Nothing> {
        mangaDao.upsertManga(mangas)
    }.flowOn(Dispatchers.IO)

    override suspend fun getMangaWithChaptersById(
        mangaId: Long
    ) = flow {
        emit(DataState.OnLoading)
        val data = mangaDao.getMangaWithChaptersById(mangaId) ?: throw Exception("Manga not found")
        emit(DataState.OnData(data))
    }.flowOn(Dispatchers.IO).catch {
        emit(DataState.OnFailure(it))
    }

    override suspend fun getAllMangas() = flow {
        emit(DataState.OnLoading)
        emit(DataState.OnData(mangaDao.getAllMangas()))
    }.flowOn(Dispatchers.IO).catch {
        emit(DataState.OnFailure(it))
    }

    override suspend fun deleteManga(
        manga: Manga
    ) = flow<Nothing> {
        mangaDao.deleteManga(manga)
    }.flowOn(Dispatchers.IO)

}