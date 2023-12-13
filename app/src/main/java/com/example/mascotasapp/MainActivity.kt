package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mascotasapp.database.Mascotas
import com.example.mascotasapp.database.MisAnimalesApp
import com.example.mascotasapp.database.Propietarios
import com.example.mascotasapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* Boton para guardar los datos del los propietarios y las mascotas */
        binding.btnGuardar.setOnClickListener{
            /* Datos de la tabla Propietario */
            var nomPropietario = binding.nombrePropietario.text.toString()
            var direcPropietario = binding.direccionPropietario.text.toString()
            var telefPropietario = binding.telefonoPropietario.text.toString()
            /* Datos de la tabla Mascotas */
            var nombreAnimal = binding.nombreMascota.text.toString()
            var esPerroGato = binding.grupoRadio.isActivated
            var razaAnimal = binding.razaMascota.text.toString()
            var fechaNacimiento = binding.fechaNacMascota.text.toString()

            /* No es necesario crear una variable para guardar el nombre del dueño del animal,
            * ya que la tabla Masc */



            CoroutineScope(Dispatchers.IO).launch{
                MisAnimalesApp.database.propietariosDAO().anadirPropietario(
                    Propietarios(
                        nombre_propietario = nomPropietario,
                        direccion_propietario = direcPropietario,
                        tlf_propietario = telefPropietario
                    )
                )
                MisAnimalesApp.database.mascotasDAO().anadirMascota(
                    Mascotas(
                        nombre = nombreAnimal,
                        esPerro = esPerroGato,
                        raza = razaAnimal,
                        fecha_nacimiento = fechaNacimiento,
                        duenio = nomPropietario
                    )
                )

            }
            binding.nombreMascota.text.clear()
            binding.razaMascota.text.clear()
            binding.fechaNacMascota.text.clear()

            runOnUiThread{true}
        }


        binding.btnOtraMascota.setOnClickListener{
            /* Datos de la tabla Mascotas */
            var propietarioMascota = binding.nombrePropietario.text.toString()
            var nombreAnimal = binding.nombreMascota.text.toString()
            var esPerroGato = binding.grupoRadio.isActivated
            var razaAnimal = binding.razaMascota.text.toString()
            var fechaNacimiento = binding.fechaNacMascota.text.toString()

            CoroutineScope(Dispatchers.IO).launch{
                MisAnimalesApp.database.mascotasDAO().anadirMascota(
                    Mascotas(
                        nombre = nombreAnimal,
                        esPerro = esPerroGato,
                        raza = razaAnimal,
                        fecha_nacimiento = fechaNacimiento,
                        duenio = propietarioMascota
                    )
                )

            }

            runOnUiThread{true}
        }

    }
}