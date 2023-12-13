package com.example.mascotasapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update


@Dao
interface PropietariosDAO {

    @Insert
    fun anadirPropietario(propietarios: Propietarios)

    @Delete
    fun eliminarPropietario(propietarios: Propietarios)

    @Update
    fun actualizarPropietario(propietarios: Propietarios)

    @Transaction
    @Query("SELECT * FROM mascotas WHERE duenio like :propietarios")
    fun obtenerpropietario(propietarios: String)


}