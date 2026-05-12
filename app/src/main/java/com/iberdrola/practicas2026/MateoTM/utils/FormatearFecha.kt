package com.iberdrola.practicas2026.MateoTM.utils

import android.icu.text.SimpleDateFormat
import java.util.Locale

fun formatearFecha(fecha: String) : String {
    val fechaEntrada = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val fechaSalida = SimpleDateFormat("d 'de' MMMM", Locale.forLanguageTag("es-ES"))

    return fechaSalida.format(fechaEntrada.parse(fecha))
}