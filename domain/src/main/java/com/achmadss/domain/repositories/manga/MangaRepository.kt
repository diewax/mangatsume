package com.achmadss.domain.repositories.manga

import com.achmadss.data.local.entities.Manga
import com.achmadss.data.local.entities.MangaWithChapters
import com.achmadss.domain.DataState
import kotlinx.coroutines.flow.Flow

interface MangaRepository {

    suspend fun upsertManga(mangas: List<Manga>): Flow<Nothing>
    suspend fun getMangaWithChaptersById(mangaId: Long): Flow<DataState<MangaWithChapters>>
    suspend fun getAllMangas(): Flow<DataState<List<Manga>>>
    suspend fun deleteManga(manga: Manga): Flow<Nothing>

}