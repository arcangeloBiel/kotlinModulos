package com.example.comum.domain.interfaceRepository

import com.example.comum.data.model.BaseResult
import com.example.comum.data.model.authApi.TokenResponse
import com.example.comum.domain.Entity.UsuarioSession

interface LoginRepository {
    suspend fun login(usuario: String, password: String): BaseResult<TokenResponse>
    suspend fun get(): UsuarioSession
    suspend fun delete(usuarioSession: UsuarioSession)
}