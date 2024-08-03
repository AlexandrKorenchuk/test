package com.example.data.mapper

import com.example.data.datasource.database.event.EventDB
import com.example.model.CompletedEvent

interface EventMapper {
    fun mapFromDB(dbEvent: EventDB): CompletedEvent
}

internal class EventMapperImpl : EventMapper {
    override fun mapFromDB(dbEvent: EventDB): CompletedEvent = CompletedEvent(dbEvent.date)
}