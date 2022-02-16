package com.example.comum.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.comum.data.local.UsuarioSessionDao
import com.example.comum.domain.Entity.UsuarioSession

@Database(version = 1, entities = [UsuarioSession::class],  exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioSessionDao(): UsuarioSessionDao

}