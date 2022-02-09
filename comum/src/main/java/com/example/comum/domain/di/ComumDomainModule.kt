package com.example.comum.domain.di

import com.example.comum.domain.useCase.LogarUseCase
import com.example.comum.domain.useCase.LogarUseCaseImpl
import org.koin.dsl.module

val useCase = module {
    factory<LogarUseCase> {
        LogarUseCaseImpl(get())
    }
}

val commonDomainModule = listOf(useCase)