package com.iberdrola.practicas2026.MateoTM.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.iberdrola.practicas2026.MateoTM.database.FacturaDao
import com.iberdrola.practicas2026.MateoTM.network.FacturaApi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FacturaRepository @Inject constructor(
    @ApplicationContext val context: Context,
    val facturaDao: FacturaDao,
    val facturaApi: FacturaApi
) {
    fun facturasJSON() : List<Factura>{
        // busca el archivo en la carpeta que está en mi proyecto el json,
        // lo lee y una vez que termine de leerlo se cierra automáticamente
        val json = context.assets.open("data/facturas.json").bufferedReader().use { it.readText() }

        val gson = Gson()
        // esto me sirve para que el compilador sepa que lo que va a hacer es leer un mapa,
        // el mapa tiene de clave un String, y su contenido contiene una lista de facturas
        val datos = object : TypeToken<Map<String, List<Factura>>>() {}.type
        val texto : Map<String, List<Factura>> = gson.fromJson(json, datos) // crea todos los objetos de Facturas

        return texto["facturas"] ?: emptyList() // la palabra facturas dentro de los [] es porque como el json empieza
       // por facturas, lo que hago, es pedir la lista que está dentro de eso
    }

    suspend fun obtenerFacturasRed(): List<Factura>{
        var api: List<Factura>
        try {
            val respuesta = facturaApi.obtenerFacturasRed() // Esto ahora devuelve el Mapa
            api = respuesta["facturas"] ?: emptyList()     // Sacamos la lista de dentro
            android.util.Log.d("NETWORK_CHECK", "Retrofit/Retromock funcionó: ${api.size} facturas")
        } catch (e: Exception){
            android.util.Log.e("NETWORK_CHECK", "Retrofit/Retromock FALLÓ: ${e.message}")
            api = emptyList()
        }
        return api
    }

    suspend fun guardarFacturasBD(facturas: List<Factura>){
        facturaDao.insertFactura(facturas)
    }
    fun obtenerFacturasBD(): Flow<List<Factura>> {
        return facturaDao.obtenerFacturas()
    }
}