package com.example.comum.data.model

import java.io.Serializable

data class Dispositivos(
    var id: Int,
    var status: String,
    var nome: String? = null,
) : Serializable

