package com.example.mascotasapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Mascotas::class, Propietarios::class],
    version =1)

abstract class DBMascotas: RoomDatabase() {

    abstract fun mascotasDAO(): MascotasDAO

    abstract fun propietariosDAO(): PropietariosDAO
}