package com.example.comum.data.repositoryImpl

import com.example.comum.data.remote.source.login.LoginRemoteDataSource
import com.example.comum.domain.model.LoginModel
import com.example.comum.domain.repository.LoginRepository
import com.example.comum.domain.useCase.LogarUseCaseImpl

class LoginRepositoryImpl(private val loginDataSource: LoginRemoteDataSource) : LoginRepository {
    override suspend fun logar(logarParams: LogarUseCaseImpl.Params): LoginModel {
        val logarResponse = loginDataSource.logar(logarParams.codigo, logarParams.senha)
        return LoginModel(logarResponse.token, logarParams.codigo)
    }
}