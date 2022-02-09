package com.example.comum.data.di

import com.example.comum.data.remote.di.commonRemoteModule
import com.example.comum.di.commonRepositoryModule
import com.example.comum.domain.di.commonDomainModule
import com.example.comum.presentation.di.commonPresentationModule

val commonModule = (commonPresentationModule + commonDomainModule + commonRepositoryModule + commonRemoteModule)
