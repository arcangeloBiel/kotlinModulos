package com.example.comum.presentation.di

import com.example.comum.presentation.ui.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { LoginViewModel(get()) }
}

val commonPresentationModule = listOf(viewModels)
