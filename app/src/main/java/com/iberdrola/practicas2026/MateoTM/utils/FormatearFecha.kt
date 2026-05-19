package com.iberdrola.practicas2026.MateoTM.utils

import android.icu.text.SimpleDateFormat
import java.util.Locale

// Función para formatear las fechas que aparecen en el listado
fun formatearFechaListado(fecha: String) : String {
    val fechaEntrada = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val fechaSalida = SimpleDateFormat("d 'de' MMMM", Locale.forLanguageTag("es-ES"))

    return fechaSalida.format(fechaEntrada.parse(fecha))
}
// Función para formatear la fecha que sale en la tarjeta de la última factura
fun formatearFechaUltimaFactura(fecha: String) : String {
    val fechaEntrada = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val fechaSalida = SimpleDateFormat("dd MMM. yyyy", Locale.forLanguageTag("es-ES"))

    return fechaSalida.format(fechaEntrada.parse(fecha))
}
fun FormatearAño(fecha: String) : String{
    val fechaEntrada = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val fechaSalida = SimpleDateFormat("yyyy", Locale.forLanguageTag("es-ES"))

    return fechaSalida.format(fechaEntrada.parse(fecha))

}