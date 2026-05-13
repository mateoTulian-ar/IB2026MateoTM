package com.iberdrola.practicas2026.MateoTM.ui.listado_facturas

import androidx.compose.runtime.mutableStateOf
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

    private var facturasCompleta: List<Factura> = emptyList() // esta es la que viene directa de mi modelo

    private val _facturas = MutableStateFlow<List<Factura>>(emptyList()) // y esa para que la ui pueda verla
    val facturas = _facturas.asStateFlow()

    private val _tabSeleccionado = MutableStateFlow(0)
    val tabSeleccionado = _tabSeleccionado.asStateFlow()

    private val _mostrarAviso = MutableStateFlow(false)
    val mostrarAviso = _mostrarAviso

    init {
        obtenerFacturas()
    }
    // función dentro de la clase para que pueda usar el parámetro de la clase de ViewModel
    fun obtenerFacturas(){
        facturasCompleta = respository.facturasJSON()
         _facturas.value = facturasCompleta
    }
    fun cambiarElTab(tab: Int){
        _tabSeleccionado.value = tab
        filtrarLista()
    }
    fun filtrarLista(){
        val tipoBuscado = if (_tabSeleccionado.value == 0) "Luz" else "Gas"

        _facturas.value = facturasCompleta.filter { factura -> factura.tipo.equals(tipoBuscado,
            ignoreCase = true) }.sortedByDescending { it.fechaExpedicion }
    }

    fun MostrarAvisoNoDisponible(mostrarAviso : Boolean){
        _mostrarAviso.value = mostrarAviso
    }
}