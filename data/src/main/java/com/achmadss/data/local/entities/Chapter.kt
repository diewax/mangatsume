package com.achmadss.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
    tableName = "chapters",
    foreignKeys = [ForeignKey(
        entity = Manga::class,
        parentColumns = arrayOf("mangaId"),
        childColumns = arrayOf("mangaId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Chapter(
    @PrimaryKey(autoGenerate = true) val chapterId: Long = 0,
    val mangaId: Long,
    val name: String,
    val dateTime: LocalDateTime,
    val imageFilenames: List<String>,
    val isRead: Boolean
)