package com.example.comum.data.remote.di

import com.example.comum.data.remote.retrofit.RetrofitInstance
import com.example.comum.data.remote.service.LoginService
import com.example.comum.data.remote.source.login.LoginRemoteDataSource
import com.example.comum.data.remote.source.login.LoginRemoteDataSourceImpl
import org.koin.dsl.module

val remoteModule = module {
    single { RetrofitInstance.provideOkHttpClient() }
    single { RetrofitInstance.create(get(), "https://caminho de sua api/") as LoginService }
   factory<LoginRemoteDataSource> { LoginRemoteDataSourceImpl(get()) }
}

val commonRemoteModule = listOf(remoteModule)
