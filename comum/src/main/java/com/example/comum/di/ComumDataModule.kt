package com.example.comum.di

import com.example.comum.data.repositoryImpl.LoginRepositoryImpl
import com.example.comum.domain.repository.LoginRepository
import org.koin.dsl.module



val reposityModule = module {
    factory<LoginRepository> { LoginRepositoryImpl(get()) }
}


val commonRepositoryModule = listOf(reposityModule)
