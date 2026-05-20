package com.iberdrola.practicas2026.MateoTM.ui.listado_facturas

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material.icons.outlined.Whatshot
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iberdrola.practicas2026.MateoTM.model.Factura
import com.iberdrola.practicas2026.MateoTM.ui.components.BotonSalir
import com.iberdrola.practicas2026.MateoTM.ui.components.BottomSheetOpinion
import com.iberdrola.practicas2026.MateoTM.ui.components.FacturaNoDisponibleDialog
import com.iberdrola.practicas2026.MateoTM.ui.components.FacturasCard
import com.iberdrola.practicas2026.MateoTM.ui.components.FacturasSkeleton
import com.iberdrola.practicas2026.MateoTM.ui.components.FiltrosNoDisponibleDialog
import com.iberdrola.practicas2026.MateoTM.ui.components.HistoricoSkeleton
import com.iberdrola.practicas2026.MateoTM.ui.components.LuzGasTabs
import com.iberdrola.practicas2026.MateoTM.ui.components.UltimaFacturaSkeleton
import com.iberdrola.practicas2026.MateoTM.ui.components.ValoracionDialog
import com.iberdrola.practicas2026.MateoTM.utils.FormatearAño
import com.iberdrola.practicas2026.MateoTM.utils.FormatearFechaUltimaFactura

@Composable
fun ListadoFacturasScreen(
    viewModel: ListadoFacturasViewModel,
    onExitClick: () -> Unit
){
    if(viewModel.state.mostrarDialogFiltro){
        FiltrosNoDisponibleDialog(
            onDismiss = { viewModel.MostrarFiltroNoDisponible(false)}
        )
    }

    if(viewModel.state.mensajeValoracion){
        ValoracionDialog (
            mensaje = viewModel.state.mensajeAgradecer,
            onDismiss = {
                viewModel.MostrarValoracion(false)
            }
        )
    }

    if(viewModel.state.mostrarOpinion){
        BottomSheetOpinion(
            onValorar = { puntos ->
                viewModel.ValoracionUsuario(puntos)
                onExitClick()
            },
            onDismiss = {
                viewModel.NoResponde()
                onExitClick()
            },
            onMasTarde = {
                viewModel.ResponderMasTarde()
                onExitClick()
            }
        )
    }
    if(viewModel.state.mostrarAviso){
        FacturaNoDisponibleDialog(onDismiss = {viewModel.MostrarAvisoNoDisponible(false)})
    }

    ListadoFacturasContent(
        facturas = viewModel.state.listadoFiltrado,
        onExitClick = {viewModel.SalirScreenPrincipal(onExitFinal = onExitClick)},
        tabSeleccionado = viewModel.state.tab,
        viewModel = viewModel,
        onTab = {nuevoTab -> viewModel.cambiarElTab(nuevoTab)}
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListadoFacturasContent(
    facturas: List<Factura>,
    tabSeleccionado: Int,
    viewModel: ListadoFacturasViewModel,
    onTab: (Int) -> Unit,
    onExitClick: () -> Unit
){

    Scaffold(
        containerColor = Color(0XFFFFFFFF),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(Color(0XFFFFFFFF)),
                title = {  },
                navigationIcon = {
                    Box(modifier = Modifier.background(Color.White)) {
                        BotonSalir ( onExitClick = onExitClick)
                    }
                }
            )
        }

    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

            Cabecera(direccion = "C/ Palma - ARTA KM 49,5,4ºA - PINTO - MADRID")

            Spacer(modifier = Modifier.height(5.dp))
            LuzGasTabs(
                seleccionado = tabSeleccionado,
                onTab = onTab
            )
            Spacer(modifier = Modifier.height(2.dp))
            ListaFacturas(
                facturas = facturas,
                viewModel = viewModel,
                tabSeleccionado = tabSeleccionado
            )
        }
    }
}

@Composable
fun Cabecera(direccion: String){
    Text(
        text = "Mis Facturas",
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(6.dp))
    Text(
        text = direccion,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}


@SuppressLint("DefaultLocale")
@Composable
fun UltimaFactura(
    factura: Factura?,
    tabSeleccionado: Int,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
){
    if (factura == null) return // por si llega a estar vacia y para arriba poder usar que sea la primera o nula
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .clickable { onCardClick() },
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, color = Color(0xFF096E19)),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Última factura",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                if (tabSeleccionado == 0){
                    Icon(
                        imageVector = Icons.Outlined.Lightbulb,
                        tint = Color(0xFF096E19),
                        contentDescription = "Bombilla",
                        modifier = Modifier
                            .size(40.dp)
                            .offset(y = 10.dp)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Outlined.Whatshot,
                        tint = Color(0xFF096E19),
                        contentDescription = "Bombilla",
                        modifier = Modifier
                            .size(40.dp)
                            .offset(y = 10.dp)
                    )
                }
            }
            Text("Factura ${factura.tipo}")

            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = String.format("%.2f", factura.valor),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = " €",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }

            Spacer(modifier = Modifier.height(2.dp))
            Text("${FormatearFechaUltimaFactura(factura.fechaInicio)} - ${FormatearFechaUltimaFactura(factura.fechaFin)}")

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 20.dp),
                color = Color(0xFF70968B)
            )

            Card(
                modifier = Modifier
                    .height(25.dp)
                    .width(135.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if(factura.estado == "Pagada") Color(0xFFB2D7BA) else Color(0xFFE18F8F))
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = factura.estado,
                        textAlign = TextAlign.Center,
                        color = if(factura.estado == "Pagada") Color(0xFF075714) else Color(0xFF5E1414),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun Historico(modifier: Modifier = Modifier, onFiltroClick: () -> Unit){
    Row(
        modifier = modifier
    ) {
        Text(
            text = "Histórico de facturas",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))

        Card(
            modifier = Modifier
                .width(105.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(20.dp))
                .clickable { onFiltroClick() },
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(2.dp, color = Color(0xFF096E19)),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Outlined.Tune,
                    tint = Color(0xFF096E19),
                    contentDescription = "Filtros",
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 7.dp)
                )
                Text(
                    text = "Filtrar",
                    color = Color(0xFF096E19),
                    fontWeight = FontWeight.Bold

                )
            }

        }
    }
}

@Composable
fun ListaFacturas(
    facturas: List<Factura>,
    viewModel: ListadoFacturasViewModel,
    tabSeleccionado: Int
){
    val facturaReciente = facturas.firstOrNull() // filtrado de la mas reciente
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        item {
            if (viewModel.state.cargando) {
                UltimaFacturaSkeleton(modifier = Modifier.padding(top = 15.dp).padding(horizontal = 18.dp))
            } else {
                UltimaFactura(
                    factura = facturaReciente, tabSeleccionado = tabSeleccionado,
                    onCardClick = { viewModel.MostrarAvisoNoDisponible(true) },
                    modifier = Modifier.padding(top = 15.dp).padding(horizontal = 18.dp)
                )
            }
        }

        item {
            if (viewModel.state.cargando) {
                HistoricoSkeleton(modifier = Modifier.padding(top = 30.dp).padding(horizontal = 18.dp))
            } else {
                Historico(
                    modifier = Modifier.padding(top = 30.dp).padding(horizontal = 18.dp),
                    onFiltroClick = { viewModel.MostrarFiltroNoDisponible(true) })
            }
        }
        item {
            if (!viewModel.state.cargando && facturaReciente != null) { // si no está cargando y la factura no es nuña entra al if
                Text(
                    text = FormatearAño(facturaReciente.fechaExpedicion),
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 20.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        if(viewModel.state.cargando){
            items(4) { FacturasSkeleton() } // carga 4 facturas para que se vean en el skeleton
        } else {
            items(facturas) { factura ->
                FacturasCard(
                    factura,
                    onFacturaClick = { viewModel.MostrarAvisoNoDisponible(true) }
                )
            }
        }
    }
}