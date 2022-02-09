package com.example.comum.domain.interfaceRepository

import com.example.comum.data.model.authApi.TokenResponse
import com.example.comum.domain.Entity.UsuarioSession

interface UsuarioRepository {

    suspend fun getUsuarioSession() : UsuarioSession

    suspend fun signIn(session: UsuarioSession)

   suspend fun updateCurrentFromToken(token: TokenResponse)  : Boolean
}