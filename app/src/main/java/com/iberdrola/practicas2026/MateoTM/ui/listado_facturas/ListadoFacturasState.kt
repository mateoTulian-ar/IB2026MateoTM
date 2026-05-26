package com.iberdrola.practicas2026.MateoTM.ui.listado_facturas

import com.iberdrola.practicas2026.MateoTM.model.Factura

data class ListadoFacturasState(
    val listadoCompleto : List<Factura> = emptyList(),
    val listadoFiltrado : List<Factura> = emptyList(),
    val tab : Int = 0,
    val mostrarOpinion: Boolean = false,
    val mensajeValoracion: Boolean = false,
    val mostrarAviso: Boolean = false,
    val mostrarFiltro: Boolean = false,
    val cargando: Boolean = false,
    val mensajeAgradecer: String = ""
)