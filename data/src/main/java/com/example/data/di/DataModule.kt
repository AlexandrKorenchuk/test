package com.example.data.di

import com.example.data.datasource.database.AppDatabase
import com.example.data.datasource.database.event.EventDao
import com.example.data.mapper.EventMapperImpl
import com.example.data.receiver.BootReceiverRepositoryImpl
import com.example.data.repository.CompletedEventRepositoryImpl
import com.example.domain.repository.BootReceiverRepository
import com.example.domain.repository.CompletedEventRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<BootReceiverRepository> {
        BootReceiverRepositoryImpl(get(), get())
    }
    single<AppDatabase> {
        AppDatabase.buildDatabase(androidContext())
    }
    factory<EventDao> {
        get<AppDatabase>().eventDao()
    }
    factory<com.example.data.mapper.EventMapper> { EventMapperImpl() }
    factory<CompletedEventRepository> { CompletedEventRepositoryImpl(get(), get()) }
}