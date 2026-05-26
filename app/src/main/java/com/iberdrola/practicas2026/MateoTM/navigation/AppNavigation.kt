package com.iberdrola.practicas2026.MateoTM.navigation

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

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rutas.Home.ruta
    ) {
        composable(Rutas.Home.ruta){
            HomeScreen(onFacturasClick = {
                navController.navigate(Rutas.Listado.ruta)
            })
        }
        composable(Rutas.Listado.ruta) {
            ListadoFacturasScreen(
                viewModel = hiltViewModel<ListadoFacturasViewModel>(),
                onExitClick = { },
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
