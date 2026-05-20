package com.iberdrola.practicas2026.MateoTM.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "facturas")
data class Factura(
    @PrimaryKey val id: Int,
    val fechaInicio: String,
    val fechaFin: String,
    val fechaExpedicion : String,
    val estado: String,
    val tipo: String,
    val valor: Double
)
