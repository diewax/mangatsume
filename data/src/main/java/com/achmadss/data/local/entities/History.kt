package com.achmadss.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "history")
data class History(
    @PrimaryKey(autoGenerate = true) val historyId: Long = 0,
    val chapterId: Long,
    val dateTime: LocalDateTime
)