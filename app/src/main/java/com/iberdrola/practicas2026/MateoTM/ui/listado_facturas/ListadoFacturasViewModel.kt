package com.iberdrola.practicas2026.MateoTM.ui.listado_facturas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var state by mutableStateOf(value = ListadoFacturasState())
        private set
    private var contadorClick = 0 
    private var proximoAviso = 0
    init {
        obtenerFacturas()
        filtrarLista()
    }
    fun obtenerFacturas(){
        val todas = respository.facturasJSON()
        state = state.copy(listadoCompleto = todas)
    }
    fun cambiarElTab(tab: Int){
       state = state.copy(tab = tab)
        filtrarLista()
    }
    fun filtrarLista(){
        val tipoBuscado = if (state.tab == 0) "Luz" else "Gas"

        state = state.copy(listadoFiltrado = state.listadoCompleto.filter { factura ->
            factura.tipo.equals(other = tipoBuscado, ignoreCase = true) }.sortedByDescending { it.fechaExpedicion }
        )
    }
    fun MostrarAvisoNoDisponible(mostrarAviso : Boolean){
        state = state.copy(mostrarAviso = mostrarAviso)
    }
    fun MostrarValoracion(valoracion: Boolean) {
        state = state.copy(mensajeValoracion = valoracion)
    }
        fun SalirScreenPrincipal(onExitFinal: () -> Unit){
        contadorClick++
        if(contadorClick >= proximoAviso){
            state = state.copy(mostrarOpinion = true)
        } else {
            onExitFinal()
        }
    }
    fun ValoracionUsuario(){
        proximoAviso = contadorClick + 10
        state = state.copy(mostrarOpinion = false)
        state = state.copy(mensajeValoracion = true)
    }
    fun ResponderMasTarde(){
        proximoAviso = contadorClick + 3
        state = state.copy(mostrarOpinion = false)
    }
    fun NoResponde(){
        proximoAviso = contadorClick + 1
        state = state.copy(mostrarOpinion = false)
    }

    fun MostrarFiltroNoDisponible(mostrarFil: Boolean){
        state = state.copy(mostrarDialogFiltro = mostrarFil)
    }
}