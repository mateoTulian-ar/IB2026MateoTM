package com.iberdrola.practicas2026.MateoTM.ui.listado_facturas

import androidx.lifecycle.ViewModel
import com.iberdrola.practicas2026.MateoTM.model.Factura
import com.iberdrola.practicas2026.MateoTM.model.FacturaRespository
import com.iberdrola.practicas2026.MateoTM.ui.components.BottomSheetOpinion
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

    private var contadorClick = 0
    private var proximoAviso = 0
    private val _bottomSheetOpinion = MutableStateFlow(false)
    val bottomSheetOpinion = _bottomSheetOpinion.asStateFlow()

    private val _valoracionUsuarioMensaje = MutableStateFlow(false)
    val valoracionUsuarioMensaje = _valoracionUsuarioMensaje.asStateFlow()

    init {
        obtenerFacturas()
        filtrarLista()
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

    fun MostrarValoracion(valoracion: Boolean) {
        _valoracionUsuarioMensaje.value = valoracion
    }
        fun SalirScreenPrincipal(onExitFinal: () -> Unit){
        contadorClick++
        if(contadorClick >= proximoAviso){
            _bottomSheetOpinion.value = true
        } else {
            onExitFinal()
        }
    }
    fun ValoracionUsuario(){
        proximoAviso = contadorClick + 10
        _bottomSheetOpinion.value = false
        _valoracionUsuarioMensaje.value = true
    }
    fun ResponderMasTarde(){
        proximoAviso = contadorClick + 3
        _bottomSheetOpinion.value = false
    }
    fun NoResponde(){
        proximoAviso = contadorClick + 1
        _bottomSheetOpinion.value = false
    }
}