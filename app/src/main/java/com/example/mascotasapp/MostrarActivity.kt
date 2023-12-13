package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mascotasapp.databinding.ActivityDeleteBinding
import com.example.mascotasapp.databinding.ActivityMostrarBinding


class MostrarActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMostrarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}