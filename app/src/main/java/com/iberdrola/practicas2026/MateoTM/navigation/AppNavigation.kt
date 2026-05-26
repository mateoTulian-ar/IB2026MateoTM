package com.iberdrola.practicas2026.MateoTM.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iberdrola.practicas2026.MateoTM.ui.filtros.FiltroScreen
import com.iberdrola.practicas2026.MateoTM.ui.filtros.FiltrosViewModel
import com.iberdrola.practicas2026.MateoTM.ui.home.HomeScreen
import com.iberdrola.practicas2026.MateoTM.ui.listado_facturas.ListadoFacturasScreen
import com.iberdrola.practicas2026.MateoTM.ui.listado_facturas.ListadoFacturasViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    // lo cambie y lo cree acá porque si no en cada pantalla muere el viewmodel y por ejemplo la valoracion no estaba aplicando su logica
    val listadoViewModel: ListadoFacturasViewModel = hiltViewModel()
        NavHost(
        navController = navController,
        startDestination = Rutas.Home.ruta
    ) {
        composable(Rutas.Home.ruta){
            HomeScreen(onFacturasClick = {
                listadoViewModel.facturasRed() // lo cargo aca para que el skeleton aparezca siempre que cambies de la pantalla home a facturas
                navController.navigate(Rutas.Listado.ruta)
            })
        }
        composable(Rutas.Listado.ruta) {
            ListadoFacturasScreen(
                viewModel = listadoViewModel,
                onExitClick = { 
                    navController.popBackStack() 
                },
                onFiltrarClick = {
                    navController.navigate(Rutas.Filtros.ruta)
                }
            )
        }
        composable(Rutas.Filtros.ruta) {
            val filtrosViewModel: FiltrosViewModel = hiltViewModel()
            FiltroScreen(
                onVolverClick = { navController.popBackStack() },
                viewModel = filtrosViewModel,
                onAplicarClick = {},
                onBorrarClick = {
                    filtrosViewModel.borrarFiltros()
                }
            )
        }
    }
}
