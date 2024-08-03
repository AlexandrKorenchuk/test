package com.example.data.datasource.database.event

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class EventDB(
    @PrimaryKey(autoGenerate = true) val uid: Int, @ColumnInfo(name = "date") val date: Long
)

