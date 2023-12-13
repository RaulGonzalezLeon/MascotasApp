package com.example.mascotasapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface MascotasDAO {

    @Insert
    fun anadirMascota(mascotas: Mascotas)

    @Delete
    fun eliminarMascota(mascotas: Mascotas)

    @Query("SELECT * FROM mascotas WHERE duenio = :nombrePropietario")
    suspend fun obtenerMascotasPorPropietario(nombrePropietario: String): List<Mascotas>

}