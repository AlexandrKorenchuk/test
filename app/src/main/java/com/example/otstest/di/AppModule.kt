package com.example.otstest.di

import com.example.otstest.presentation.main.MainActivity
import org.koin.core.qualifier.named
import org.koin.dsl.module

val koinAppModule = module {
    scope(named(MainActivity.DI_SCOPE_NAME)){
    }
}