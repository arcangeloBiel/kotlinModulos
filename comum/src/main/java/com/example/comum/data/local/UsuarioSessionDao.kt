package com.example.comum.data.local

import androidx.room.*
import com.example.comum.domain.Entity.UsuarioSession
import kotlinx.coroutines.flow.Flow


@Dao
interface UsuarioSessionDao {

    @Query("SELECT * from UsuarioSession limit 1")
    fun getUsuarioSession(): Flow<UsuarioSession?>

    @Query("SELECT * FROM UsuarioSession")
    fun get(): Flow<List<UsuarioSession>>



    @Insert
    fun insert(vararg  usuario: UsuarioSession)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertUsuario(vararg usuario: UsuarioSession)

//    @Delete
//    suspend fun deleteUsuario(
//        vararg usuario: UsuarioSession
//    )

}