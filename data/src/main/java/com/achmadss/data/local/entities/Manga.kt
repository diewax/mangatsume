package com.achmadss.data.local.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "mangas")
data class Manga(
    @PrimaryKey(autoGenerate = true) val mangaId: Long = 0,
    val name: String,
    val description: String,
    val artists: List<String>,
    val authors: List<String>,
    val genres: List<String>,
    val status: String,
    val url: String,
    val coverFilename: String
)

data class MangaWithChapters(
    @Embedded val manga: Manga,
    @Relation(
        parentColumn = "mangaId",
        entityColumn = "mangaId"
    )
    val chapters: List<Chapter>
)