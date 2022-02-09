package com.example.comum.domain.useCase

import com.example.comum.domain.model.LoginModel
import com.example.comum.domain.useCase.LogarUseCaseImpl.Params as LogarParams

interface LogarUseCase {
    suspend fun logar(model: LogarParams): LoginModel

}