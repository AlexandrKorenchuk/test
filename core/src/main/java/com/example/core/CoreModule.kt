package com.example.core

import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.utils.di.utilsModule
import org.koin.dsl.module

val coreModule = module {
    includes(dataModule, domainModule, utilsModule)
}