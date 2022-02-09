package com.example.comum.domain.repository

import com.example.comum.domain.Entity.UsuarioSession
import com.example.comum.domain.model.LoginModel
import com.example.comum.domain.useCase.LogarUseCaseImpl.Params as LogarParans


interface LoginRepository {
    suspend fun logar(logarParams: LogarParans) : LoginModel

}