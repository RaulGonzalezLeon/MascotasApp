package com.example.mascotasapp.database

import android.app.Application
import androidx.room.Room

class MisAnimalesApp:Application() {

    companion object{
        lateinit var database: DBMascotas
    }

    override fun onCreate() {
        super.onCreate()
        MisAnimalesApp.database = Room.databaseBuilder(this, DBMascotas::class.java,"DBMascotas").build()
    }
}