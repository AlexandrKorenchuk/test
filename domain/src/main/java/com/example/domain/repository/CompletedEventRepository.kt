package com.example.domain.repository

import com.example.model.CompletedEvent
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface CompletedEventRepository {
    fun save(date: Long): Completable
    fun getAll(): Single<List<CompletedEvent>>
}