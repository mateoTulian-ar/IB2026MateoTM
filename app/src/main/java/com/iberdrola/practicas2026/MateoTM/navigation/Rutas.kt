package com.iberdrola.practicas2026.MateoTM.navigation

sealed class Rutas(val ruta: String) {
    object Listado : Rutas("listado")
    object Filtros : Rutas("filtros")
    object Home: Rutas("home")
}