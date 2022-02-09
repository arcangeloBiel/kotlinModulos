package com.example.comum.data.remote.source.login

import com.example.comum.data.remote.service.LoginService

class LoginRemoteDataSourceImpl(private val loginService: LoginService): LoginRemoteDataSource {
    override suspend fun logar(codigo: String, senha: String): LoginResponseModel {
        return loginService.logar(codigo = codigo,senha = senha)
    }
}