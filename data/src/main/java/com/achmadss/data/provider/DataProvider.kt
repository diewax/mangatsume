package com.achmadss.data.provider

import android.content.Context
import androidx.room.Room
import com.achmadss.data.local.database.MangatsumeDatabase

class DataProvider {
    companion object {
        fun initializeDatabase(context: Context): MangatsumeDatabase = Room.databaseBuilder(
            context, MangatsumeDatabase::class.java, MangatsumeDatabase.name
        ).fallbackToDestructiveMigration().build()
    }
}