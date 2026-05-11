package com.iberdrola.practicas2026.MateoTM.ui.listado_facturas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iberdrola.practicas2026.MateoTM.model.FacturaRespository


// Esta clase me sirve para poder crear el ViewModel porque ya tiene un parámetro, si está vacío no hace falta
class ListadoFacturasViewModelFactory (private val repository: FacturaRespository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // comprobacion hecha porque no me encontraba la clase del ViewModel, entonces lo refactoricé de esa manera lanzando una expeción si no lo encunentra
        if (modelClass.isAssignableFrom(ListadoFacturasViewModel::class.java)) {
            return ListadoFacturasViewModel(repository) as T
        }
        throw IllegalArgumentException("Clase viewmodel desconocida")
    }
}