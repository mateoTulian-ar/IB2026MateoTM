package com.iberdrola.practicas2026.MateoTM.model

data class Factura(
    val id: Int,
    val fechaInicio: String,
    val fechaFin: String,
    val fechaExpedicion : String,
    val estado: String,
    val tipo: String,
    val valor: Double
)
