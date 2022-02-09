package com.example.comum.domain.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UsuarioSession")
data class UsuarioSession(
    @PrimaryKey
    var id: Long? = 0,
    var codigo: String? = null,
    var nome: String? = null,
    var empresa: Int? = 0,
    var filial: Int? = 0,
    var token: String? = null,
    var localEstoque: String? = null,
    var nomeFilial: String? = null,
    var access_token: String? = null,
    var expires_in: Int? = 0,
    var loginTime: Int? = 0,
    var refresh_token: String? = null,
    var tipoEstoque: String? = null,
    var admin: Boolean? = false
)