package com.example.data.datasource.database.event

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface EventDao {
    @Query("INSERT INTO events (date) VALUES (:date)")
    fun insert(date: Long): Completable

    @Query("SELECT * FROM events")
    fun getAll(): Single<List<EventDB>>
}