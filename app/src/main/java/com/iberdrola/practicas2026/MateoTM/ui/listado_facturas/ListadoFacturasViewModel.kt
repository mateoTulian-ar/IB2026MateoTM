package com.iberdrola.practicas2026.MateoTM.ui.listado_facturas

import androidx.lifecycle.ViewModel
import com.iberdrola.practicas2026.MateoTM.model.Factura
import com.iberdrola.practicas2026.MateoTM.model.FacturaRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ListadoFacturasViewModel @Inject constructor(
    val respository: FacturaRespository
) : ViewModel(){
    // aca creo el estado para poder guardar la lista, vacía al principio luego le cargo los datos
    private val _facturas = MutableStateFlow<List<Factura>>(emptyList())
    val facturas = _facturas.asStateFlow()

    private val tabSeleccionado = MutableStateFlow(0)
    val tabseleccionado = tabSeleccionado.asStateFlow()

    init {
        obtenerFacturas()
    }
    // función dentro de la clase para que pueda usar el parámetro de la clase de ViewModel
    fun obtenerFacturas(){
        val facturasResultado = respository.facturasJSON()
         _facturas.value = facturasResultado.sortedByDescending { it.fechaInicio }
    }
    fun cambiarElTab(tab: Int){
        tabSeleccionado.value = tab
    }
}