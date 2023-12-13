package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mascotasapp.database.MisAnimalesApp
import com.example.mascotasapp.database.Propietarios
import com.example.mascotasapp.databinding.ActivityDeleteBinding
import com.example.mascotasapp.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UpdateActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnActualizar.setOnClickListener{

            var propietario = binding.nPropietario.text.toString()
            var newDireccion = binding.nuevaDireccion.text.toString()
            CoroutineScope(Dispatchers.IO).launch {
                MisAnimalesApp.database.propietariosDAO().actualizarPropietario(
                    Propietarios(
                        nombre_propietario = propietario,
                        direccion_propietario = newDireccion
                    )
                )
                runOnUiThread{true}
            }
        }
    }
}