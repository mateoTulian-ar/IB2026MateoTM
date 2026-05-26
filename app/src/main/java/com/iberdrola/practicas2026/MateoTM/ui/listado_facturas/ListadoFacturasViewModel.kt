package com.iberdrola.practicas2026.MateoTM.ui.listado_facturas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iberdrola.practicas2026.MateoTM.model.Factura
import com.iberdrola.practicas2026.MateoTM.model.FacturaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

@HiltViewModel
class ListadoFacturasViewModel @Inject constructor(
    val repository: FacturaRepository
) : ViewModel() {
    var state by mutableStateOf(value = ListadoFacturasState())
        private set // solo editable en el viewModel
    val tiempoAleatorio = (1000..3000).random().milliseconds
    private var contadorClick = 0
    private var proximoAviso = 0

    init {
        observarFacturas()
        facturasRed()
        //facturasLocal()
    }
    private fun observarFacturas() {
        viewModelScope.launch {
            repository.obtenerFacturasBD().collect { facturasBD ->
                state = state.copy(listadoCompleto = facturasBD)
                filtrarLista()
            }
        }
    }

    // función encargada de procesar solo una vez las facturas
    private fun procesarLasFacturas(facturas: List<Factura>) {
        viewModelScope.launch {
            if (facturas.isNotEmpty()) {
                repository.guardarFacturasBD(facturas)
            } else {
                state = state.copy(cargando = false)
            }
        }
    }
    //esta es la que usa retrofit y retromock
    fun facturasRed() {
        viewModelScope.launch {
            state = state.copy(cargando = true)
            val facturas = repository.obtenerFacturasRed()

            procesarLasFacturas(facturas)
            state = state.copy(cargando = false)
        }
    }
    // y esta la antigua, que sigue cargando del local
    fun facturasLocal() {
        viewModelScope.launch {
            state = state.copy(cargando = true)
            val facturas = repository.facturasJSON()

            procesarLasFacturas(facturas)
        }
    }
    fun cambiarElTab(tab: Int) {
        state = state.copy(tab = tab)
        filtrarLista() // si no la filtro acá también nunca me carga la lista de las de gas en este caso porque las de luz están por defecto.
    }
    fun filtrarLista() {
        val tipoBuscado = if (state.tab == 0) "Luz" else "Gas"
        val filtradas = state.listadoCompleto.filter { factura ->
            factura.tipo.equals(other = tipoBuscado, ignoreCase = true)
        }.sortedByDescending { it.fechaExpedicion }
        state = state.copy(listadoFiltrado = filtradas)
    }
    fun mostrarAvisoNoDisponible(mostrarAviso: Boolean) {
        state = state.copy(mostrarAviso = mostrarAviso)
    }
    fun mostrarValoracion(valoracion: Boolean) {
        state = state.copy(mensajeValoracion = valoracion)
    }
    fun salirScreenPrincipal(onExitFinal: () -> Unit) {
        contadorClick++
        if (contadorClick >= proximoAviso) {
            state = state.copy(mostrarOpinion = true)
        } else {
            onExitFinal()
        }
    }

    // Mensaje de agradecimiento dependiendo que carita de valoración pulsa el usuario, además si el usuario valora, no se lo pregunta hasta que salga 10 veces más
    fun valoracionUsuario(puntos: Int) {
        proximoAviso = contadorClick + 10
        val mensaje = when (puntos) {
            1 -> "Sentimos mucho que tu experiencia sea mala. Tomamos nota para mejorar."
            2 -> "Sentimos que no estés satisfecho. Trabajaremos en ello."
            3 -> "Gracias! Seguiremos mejorando para darte un mejor servicio."
            4 -> "Nos alegra que te guste! Gracias por tu confianza!"
            5 -> "Genial! Nos encanta que estés tan contento con el servicio!"
            else -> "Gracias por tu valoración."
        }
        state = state.copy(
            mostrarOpinion = false,
            mensajeValoracion = true,
            mensajeAgradecer = mensaje
        )
    }
    // Si le da a respoder más tarde se le muestre a la tercer vez que intenta salir
    fun responderMasTarde() {
        proximoAviso = contadorClick + 3
        state = state.copy(mostrarOpinion = false)
    }
    // si no responde, toca otra parte de la pantalla, se sale de la aplicación o alguna cosa que haga que no sea valorar o responder más tarde,
    // le sale la pantalla de opinión cada vez que quiera salir
    fun noResponde() {
        proximoAviso = contadorClick + 1
        state = state.copy(mostrarOpinion = false)
    }
    fun mostrarFiltroNoDisponible(mostrarFil: Boolean) {
        state = state.copy(mostrarDialogFiltro = mostrarFil)
    }
}