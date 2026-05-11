package com.iberdrola.practicas2026.MateoTM.ui.listado_facturas

import androidx.lifecycle.ViewModel
import com.iberdrola.practicas2026.MateoTM.model.Factura
import com.iberdrola.practicas2026.MateoTM.model.FacturaRespository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ListadoFacturasViewModel(private val respository: FacturaRespository) : ViewModel(){
    // aca creo el estado para poder guardar la lista, vacía al principio luego le cargo los datos
    private val _facturas = MutableStateFlow<List<Factura>>(emptyList())

    val facturas: StateFlow<List<Factura>> = _facturas.asStateFlow() // para que la screen pueda leerlo


    // función dentro de la clase para que pueda usar el parámetro de la clase de ViewModel
    fun obtenerFacturas(){
        val facturasResultado = respository.facturasJSON()

        _facturas.value = facturasResultado

    }
}