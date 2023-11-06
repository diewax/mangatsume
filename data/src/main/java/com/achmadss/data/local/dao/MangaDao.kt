package com.achmadss.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.achmadss.data.local.entities.Manga
import com.achmadss.data.local.entities.MangaWithChapters

@Dao
interface MangaDao {
    @Upsert
    suspend fun upsertManga(mangas: List<Manga>)

    @Transaction // This annotation is important for relations
    @Query("SELECT * FROM mangas WHERE mangaId =:mangaId")
    suspend fun getMangaWithChaptersById(mangaId: Long): MangaWithChapters?

    @Query("SELECT * FROM mangas")
    suspend fun getAllMangas(): List<Manga>

    @Transaction
    @Query("SELECT * FROM mangas")
    suspend fun getAllMangasWithChapters(): List<MangaWithChapters>

    @Delete
    suspend fun deleteManga(manga: Manga)
}
