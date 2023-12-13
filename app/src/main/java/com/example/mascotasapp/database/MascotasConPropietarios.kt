package com.example.mascotasapp.database

import androidx.room.Embedded
import androidx.room.Relation

data class MascotasConPropietarios(
    @Embedded val propietarios: Propietarios,
    @Relation(
        parentColumn = "nombre_propietario",
        entityColumn = "duenio"
    )
    val mascotas: MutableList<Mascotas>
)