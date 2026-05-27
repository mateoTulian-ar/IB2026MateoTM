package com.iberdrola.practicas2026.MateoTM.ui.filtros

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iberdrola.practicas2026.MateoTM.ui.components.BotonSalir
import com.iberdrola.practicas2026.MateoTM.ui.filtros.components_filtros.BorrarFiltros
import com.iberdrola.practicas2026.MateoTM.ui.filtros.components_filtros.BotonAplicarFiltros
import com.iberdrola.practicas2026.MateoTM.ui.filtros.components_filtros.FiltarPorFecha
import com.iberdrola.practicas2026.MateoTM.ui.filtros.components_filtros.FiltrarPorEstado
import com.iberdrola.practicas2026.MateoTM.ui.filtros.components_filtros.FiltrarPorImporte

@Composable
fun FiltroScreen(
    onVolverClick: () -> Unit,
    viewModel: FiltrosViewModel,
    onAplicarClick: () -> Unit,
    onBorrarClick: () -> Unit
) {
    FiltroContent(
        onSalirClick = onVolverClick,
        viewModel = viewModel,
        onAplicarClick = onAplicarClick,
        onBorrarClick = onBorrarClick

    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FiltroContent(
    onSalirClick: () -> Unit,
    viewModel: FiltrosViewModel,
    onAplicarClick: () -> Unit,
    onBorrarClick: () -> Unit
) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0XFFFFFFFF)),
                title = { },
                navigationIcon = {
                    BotonSalir(onExitClick = onSalirClick)
                }
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .navigationBarsPadding() // Subir contenido sobre la barra del sistema
                    .padding(bottom = 16.dp), // Espacio inferior extra
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BotonAplicarFiltros(onAplicarClick = onAplicarClick)
                BorrarFiltros(onBorrarClick = onBorrarClick)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Text(
                text = "Filtrar",
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 10.dp)
            )
            Text(
                text = "Por fecha",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 15.dp)
            )
            FiltarPorFecha()
            Text(
                text = "Por un importe",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 35.dp)
            )
            FiltrarPorImporte(viewModel = viewModel)
            Text(
                text = "Por estado",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 35.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            FiltrarPorEstado(viewModel = viewModel)
        }
    }
}