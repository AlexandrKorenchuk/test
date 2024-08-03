package com.example.utils.di

import com.example.utils.broadcast.BroadcastManager
import com.example.utils.broadcast.BroadcastManagerImpl
import com.example.utils.interactor.EventInteractor
import com.example.utils.interactor.EventInteractorImpl
import com.example.utils.provider.BaseSchedulerProvider
import com.example.utils.provider.SchedulerProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val utilsModule = module {
    single<EventInteractor> { EventInteractorImpl(get()) }
    factory<BroadcastManager> { BroadcastManagerImpl(androidContext()) }
    factory<BaseSchedulerProvider> { SchedulerProvider() }
}
