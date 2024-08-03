package com.example.data.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.datasource.database.event.EventDB
import com.example.data.datasource.database.event.EventDao

@Database(
    entities = [EventDB::class], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun eventDao(): EventDao

    companion object {
        private const val databaseName = "ots-database"

        fun buildDatabase(context: Context): AppDatabase = Room.databaseBuilder(
            context, AppDatabase::class.java, databaseName
        ).build()
    }
}