package com.example.data.repository

import com.example.data.datasource.database.event.EventDao
import com.example.data.mapper.EventMapper
import com.example.domain.repository.CompletedEventRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class CompletedEventRepositoryImpl(
    private val eventDao: EventDao, private val eventMapper: EventMapper
) : CompletedEventRepository {
    override fun save(date: Long): Completable = eventDao.insert(date)
    override fun getAll(): Single<List<com.example.model.CompletedEvent>> =
        eventDao.getAll().map { it.map { event -> eventMapper.mapFromDB(event) } }
}