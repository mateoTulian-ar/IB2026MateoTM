package com.iberdrola.practicas2026.MateoTM.ui.listado_facturas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iberdrola.practicas2026.MateoTM.model.FacturaRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

@HiltViewModel
class ListadoFacturasViewModel @Inject constructor(
    val respository: FacturaRespository
) : ViewModel(){
    var state by mutableStateOf(value = ListadoFacturasState())
        private set
    val tiempoAleatorio = (1000..3000).random().milliseconds
    private var contadorClick = 0
    private var proximoAviso = 0
    init {
        obtenerFacturas()
    }
    fun obtenerFacturas(){
        // corrutina para que la app sea capaz de esperar si que se congele la pantalla-
        viewModelScope.launch {
            state = state.copy(cargando = true)
            delay(tiempoAleatorio) // un tiempo de espera entre 1-3 segundos
            val todas = respository.facturasJSON()
            state = state.copy(listadoCompleto = todas, cargando = false) // una vez que el json está cargado, se le asigna al estado y cargando se desactiva
            filtrarLista()
        }
    }
    fun cambiarElTab(tab: Int){
       state = state.copy(tab = tab)
       filtrarLista() // si no la filtro acá también nunca me carga la lista de las de gas en este caso porque las de luz están por defecto.
    }
    fun filtrarLista(){
        val tipoBuscado = if (state.tab == 0) "Luz" else "Gas"
        state = state.copy(listadoFiltrado = state.listadoCompleto.filter { factura ->
            factura.tipo.equals(other = tipoBuscado, ignoreCase = true) }.sortedByDescending { it.fechaExpedicion } // filtro buscando la que sea igual al tipoBuscado, luz o gas
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
    // Mensaje de agradecimiento dependiendo que carita de valoración pulsa el usuario, además si el usuario valora, no se lo pregunta hasta que salga 10 veces más
    fun ValoracionUsuario(puntos: Int){
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
    fun ResponderMasTarde(){
        proximoAviso = contadorClick + 3
        state = state.copy(mostrarOpinion = false)
    }
    // si no responde, toca otra parte de la pantalla, se sale de la aplicación o alguna cosa que haga que no sea valorar o responder más tarde,
    // le sale la pantalla de opinión cada vez que quiera salir
    fun NoResponde(){
        proximoAviso = contadorClick + 1
        state = state.copy(mostrarOpinion = false)
    }

    fun MostrarFiltroNoDisponible(mostrarFil: Boolean){
        state = state.copy(mostrarDialogFiltro = mostrarFil)
    }
}