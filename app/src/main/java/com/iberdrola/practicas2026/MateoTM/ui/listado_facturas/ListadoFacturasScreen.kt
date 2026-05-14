package com.iberdrola.practicas2026.MateoTM.ui.listado_facturas

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.iberdrola.practicas2026.MateoTM.ui.components.FacturaNoDisponibleDialog
import com.iberdrola.practicas2026.MateoTM.ui.components.FacturasCard
import com.iberdrola.practicas2026.MateoTM.ui.components.LuzGasTabs
import com.iberdrola.practicas2026.MateoTM.utils.formatearFechaUltimaFactura

@Composable
fun ListadoFacturasScreen(
    viewModel: ListadoFacturasViewModel,
    onExitClick: () -> Unit
){
    val tab by viewModel.tabSeleccionado.collectAsState()
    val facturasResultFinal by viewModel.facturas.collectAsState() // esto para que se actualicen los cambios y los que se pasen sean los finales
    ListadoFacturasContent(
        facturas = facturasResultFinal,
        onExitClick = onExitClick,
        tabSeleccionado = tab,
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
    val mostarAviso by viewModel.mostrarAviso.collectAsState()
    if(mostarAviso){
        FacturaNoDisponibleDialog(onDismiss = {viewModel.MostrarAvisoNoDisponible(false)})
    }
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {  },
                navigationIcon = {
                    BotonSalir ( onExitClick = onExitClick)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )

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

            val facturaReciente = facturas.firstOrNull() // filtrado de la mas reciente

            //Spacer(modifier = Modifier.height(5.dp))
            UltimaFactura(factura = facturaReciente, tabSeleccionado = tabSeleccionado,
                onCardClick = {viewModel.MostrarAvisoNoDisponible(true)})

            Spacer(modifier = Modifier.height(15.dp))
            Historico()

            Spacer(modifier = Modifier.height(2.dp))

            ListaFactura(facturas = facturas, viewModel = viewModel) // aca están los cambios recibidos desde ListaFactura

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

@Composable
fun UltimaFactura(factura: Factura?, tabSeleccionado: Int, onCardClick: () -> Unit){
    if (factura == null) return // por si llega a estar vacia y para arriba poder usar que sea la primera o nula
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
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

            //Spacer(modifier = Modifier.padding(vertical = 1.dp))
            //Text(text = "Factura Luz")
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
            Text("${formatearFechaUltimaFactura(factura.fechaInicio)} - ${formatearFechaUltimaFactura(factura.fechaFin)}")

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
                        text = "${factura.estado}",
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
fun Historico(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)
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
                .clickable { },
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
fun ListaFactura(
    facturas: List<Factura>,
    viewModel: ListadoFacturasViewModel
){
    // val facturas = listOf("2 de marzo", "15 de marzo", "1 de abril", "20 de abril", "5 de mayo", "12 de mayo")

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)
    ) {
        item {
            Text(
                text = "2024",
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 2.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        items(facturas) { factura ->
            FacturasCard(
                factura,
                onFacturaClick = { viewModel.MostrarAvisoNoDisponible(true) }
            )
        }
    }
}