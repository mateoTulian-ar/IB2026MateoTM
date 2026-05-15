package com.iberdrola.practicas2026.MateoTM.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

class FacturaRespository @Inject constructor(
    @ApplicationContext val context: Context
) {
    fun facturasJSON() : List<Factura>{
        val tiempoAlea = (1000..3000).random().milliseconds
        val json = context.assets.open("data/facturas.json").bufferedReader().use { it.readText() }

        val gson = Gson()

        val datos = object : TypeToken<Map<String, List<Factura>>>() {}.type
        val texto : Map<String, List<Factura>> = gson.fromJson(json, datos)

        return texto["facturas"] ?: emptyList()
    }
}