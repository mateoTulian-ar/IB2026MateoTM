package com.iberdrola.practicas2026.MateoTM.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iberdrola.practicas2026.MateoTM.model.Factura

@Database(entities = [Factura::class], version = 1)
abstract class Database: RoomDatabase(){
    abstract fun FacturaDao(): FacturaDao
}