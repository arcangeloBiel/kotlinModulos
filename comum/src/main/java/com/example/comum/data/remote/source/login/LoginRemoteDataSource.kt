package com.example.comum.data.remote.source.login

interface LoginRemoteDataSource {
    suspend fun logar(codigo: String, senha: String): LoginResponseModel
}