package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mascotasapp.database.MisAnimalesApp
import com.example.mascotasapp.databinding.ActivityDeleteBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DeleteActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btonEliminar.setOnClickListener {
            /* Datos de la tabla Propietario */
            var nomPropietario = binding.escribePropietario.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                // Obtener el objeto propietario utilizando el nombre
                val propietario = MisAnimalesApp.database.propietariosDAO().obtenerpropietario(nomPropietario)

                if (propietario != null) {
                    // Obtener todas las mascotas asociadas a ese propietario
                    val listaMascotas = MisAnimalesApp.database.mascotasDAO().obtenerMascotasPorPropietario(propietario)

                    // Eliminar cada mascota de la base de datos
                    for (mascota in listaMascotas) {
                        MisAnimalesApp.database.mascotasDAO().eliminarMascota(mascota)
                    }
                }
            }
        }

    }
}