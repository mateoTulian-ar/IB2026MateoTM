package com.iberdrola.practicas2026.MateoTM.ui.filtros

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iberdrola.practicas2026.MateoTM.model.FacturaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FiltrosViewModel @Inject constructor(
    private val repository: FacturaRepository
) : ViewModel(){
    var state by mutableStateOf(value = FiltrosState())

    init {
        obtenerRangoPrecios()
    }

    fun obtenerRangoPrecios() {
        viewModelScope.launch {
            val facturas = repository.obtenerFacturasBD().first()
            if (facturas.isNotEmpty()) {
                val min = facturas.minOf { it.valor }.toFloat() // busco el valor minimo y lo convierto a float
                val max = facturas.maxOf { it.valor }.toFloat() // busco el valor máximo
                state = state.copy(
                    // le asigno al state declarado cada uno de sus valores
                    minValorSlider = min,
                    maxValorSlider = max,
                    rangoPrecio = min..max
                )
            }
        }
    }

    fun cambiarRangoPrecios(rango: ClosedFloatingPointRange<Float>){
        state = state.copy(rangoPrecio = rango)
    }

    fun filtradoPagadas(estado: Boolean){
        state = state.copy(filtrarPagadas = (estado))
    }
    fun filtradoPendientes(estado: Boolean){
        state = state.copy(filtrarPendientes = (estado))
    }
    fun filtradoEnTramite(estado: Boolean){
        state = state.copy(filtrarEnTramite = (estado))
    }
    fun filtradoAnuladas(estado: Boolean){
        state = state.copy(filtrarAnuladas = (estado))
    }
    fun filtradoCuotaFija(estado: Boolean){
        state = state.copy(filtrarCuotaFjia = (estado))
    }

    fun borrarFiltros() {
        state = state.copy(
            filtrarPagadas = false,
            filtrarPendientes = false,
            filtrarEnTramite = false,
            filtrarAnuladas = false,
            filtrarCuotaFjia = false,
            rangoPrecio = state.minValorSlider..state.maxValorSlider
        )
    }
}