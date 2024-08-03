package com.example.domain.di

import com.example.domain.event.GetEventsUseCase
import com.example.domain.event.GetEventsUseCaseImpl
import com.example.domain.event.SaveEventUseCase
import com.example.domain.event.SaveEventUseCaseImpl
import com.example.domain.receiver.FinishBootReceiverUseCase
import com.example.domain.receiver.FinishBootReceiverUseCaseImpl
import com.example.domain.receiver.StartBootReceiverUseCase
import com.example.domain.receiver.StartBootReceiverUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<StartBootReceiverUseCase> { StartBootReceiverUseCaseImpl(get()) }
    factory<FinishBootReceiverUseCase> { FinishBootReceiverUseCaseImpl(get()) }
    factory<SaveEventUseCase> { SaveEventUseCaseImpl(get(), get()) }
    factory<GetEventsUseCase> { GetEventsUseCaseImpl(get(), get()) }
}