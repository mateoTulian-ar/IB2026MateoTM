package com.iberdrola.practicas2026.MateoTM.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FacturaRespository(val context: Context) {

    fun facturasJSON() : List<Factura>{
        val json = context.assets.open("data/facturas.json").bufferedReader().use { it.readText() }

        val gson = Gson()

        val datos = object : TypeToken<Map<String, List<Factura>>>() {}.type
        val texto : Map<String, List<Factura>> = gson.fromJson(json, datos)

        return texto["facturas"] ?: emptyList()
    }
}