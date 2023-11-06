package com.achmadss.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.achmadss.data.local.dao.ChapterDao
import com.achmadss.data.local.dao.HistoryDao
import com.achmadss.data.local.dao.MangaDao
import com.achmadss.data.local.entities.Manga
import com.achmadss.data.local.entities.Chapter
import com.achmadss.data.local.entities.History

@Database(
    entities = [
        Manga::class,
        Chapter::class,
        History::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class LocalDataSource : RoomDatabase() {
    abstract fun mangaDao(): MangaDao
    abstract fun chapterDao(): ChapterDao
    abstract fun historyDao(): HistoryDao

    companion object {
        const val name = "mangatsume_db"
    }
}