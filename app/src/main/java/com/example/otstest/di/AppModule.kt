package com.example.otstest.di

import com.example.otstest.presentation.events.EventsPresenter
import com.example.otstest.presentation.main.MainActivity
import com.example.otstest.presentation.main.MainPresenter
import org.koin.core.qualifier.named
import org.koin.dsl.module

val koinAppModule = module {
    scope(named(MainActivity.DI_SCOPE_NAME)) {
    }
}