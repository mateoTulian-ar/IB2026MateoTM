package com.iberdrola.practicas2026.MateoTM.ui.filtros

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iberdrola.practicas2026.MateoTM.ui.components.BotonSalir

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

@Composable
fun FiltarPorFecha() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 25.dp)
    ) {
        Column() {
            Text(
                text = "* Desde",
                color = Color.Gray,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(200.dp))
            Icon(
                imageVector = Icons.Outlined.CalendarToday,
                contentDescription = "Calendario",
                modifier = Modifier
                    .offset(x = 140.dp, y = -15.dp)
                    .size(22.dp),
                tint = Color.Gray
            )

            HorizontalDivider(
                color = Color(0xFF5F6368),
                modifier = Modifier.width(165.dp),
                thickness = 2.dp
            )
        }
        Column() {
            Text(
                text = "* Hasta",
                color = Color.Gray,
                fontSize = 14.sp
            )
            Icon(
                imageVector = Icons.Outlined.CalendarToday,
                contentDescription = "Calendario",
                modifier = Modifier
                    .offset(x = 140.dp, y = -15.dp)
                    .size(22.dp),
                tint = Color.Gray
            )
            HorizontalDivider(
                color = Color(0xFF5F6368),
                modifier = Modifier.width(165.dp),
                thickness = 2.dp
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FiltrarPorImporte(viewModel: FiltrosViewModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFFDBF1E5),
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(
                    horizontal = 12.dp, vertical = 6.dp
                )
        ) {
            Text(
                // acá pongo el precio de mi factura mas bajo junto con el precio de la factura mas alto
                text = "${viewModel.state.rangoPrecio.start.toInt()} € - ${viewModel.state.rangoPrecio.endInclusive.toInt()} €",
                color = Color(0xFF2C3E35),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
        RangeSlider(
            value = viewModel.state.rangoPrecio,
            onValueChange = { rangoCambiado -> viewModel.cambiarRangoPrecios(rangoCambiado) },
            valueRange = viewModel.state.minValorSlider..viewModel.state.maxValorSlider,
            track = { rangeSliderState ->// personalizo la linea como se ve en la práctica
                SliderDefaults.Track(
                    rangeSliderState = rangeSliderState,
                    modifier = Modifier.height(5.dp),
                    thumbTrackGapSize = 0.dp, // con esto saco el espacio que se me quedaba entre los circulos y la linea del slider
                    colors = SliderDefaults.colors(
                        activeTrackColor = Color(0xFF03592B),
                        inactiveTrackColor = Color(0xFFDBF1E5) // color de atrás
                    )
                )
            },
            colors = SliderDefaults.colors(
                activeTrackColor = Color(0xFF03592B),
                inactiveTrackColor = Color.LightGray
            ),
            startThumb = { // circulo del principio
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(
                            color = Color(0xFF03592B),
                            shape = CircleShape
                        )
                )
            },
            endThumb = {// circulo del final
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(
                            color = Color(0xFF03592B),
                            shape = CircleShape
                        )
                )
            },

            )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        ) {
            Text(
                text = "${viewModel.state.minValorSlider.toInt()} €", // lo convierto a toInt para poder sacar los decimales
                color = Color.Gray,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${viewModel.state.maxValorSlider.toInt()} €",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun FiltrarPorEstado(viewModel: FiltrosViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .width(145.dp)
                .padding(horizontal = 10.dp)
                .clip(RoundedCornerShape(12.dp))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = ripple(color = Color.Gray),
                    onClick = { viewModel.filtradoPagadas(!viewModel.state.filtrarPagadas) } // filtra cuando el estado es true
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = viewModel.state.filtrarPagadas,
                onCheckedChange = { nuevoEstado -> viewModel.filtradoPagadas(nuevoEstado) },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color(0xFF03592B),
                    checkedColor = Color(0xFF03592B)
                )
            )
            Text(
                text = "Pagadas"
            )
        }
        Row(
            modifier = Modifier
                .width(210.dp)
                .padding(horizontal = 10.dp)
                .clip(RoundedCornerShape(12.dp))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = ripple(color = Color.Gray),
                    onClick = { viewModel.filtradoPendientes(!viewModel.state.filtrarPendientes) }
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = viewModel.state.filtrarPendientes,
                onCheckedChange = { nuevoEstado -> viewModel.filtradoPendientes(nuevoEstado) },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color(0xFF03592B),
                    checkedColor = Color(0xFF03592B)
                )
            )
            Text(
                text = "Pendiente de Pago"
            )
        }
        Row(
            modifier = Modifier
                .width(210.dp)
                .padding(horizontal = 10.dp)
                .clip(RoundedCornerShape(12.dp))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = ripple(color = Color.Gray),
                    onClick = { viewModel.filtradoEnTramite(!viewModel.state.filtrarEnTramite) }
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = viewModel.state.filtrarEnTramite,
                onCheckedChange = { nuevoEstado -> viewModel.filtradoEnTramite(nuevoEstado) },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color(0xFF03592B),
                    checkedColor = Color(0xFF03592B)
                )
            )
            Text(
                text = "En trámite de cobro"
            )
        }
        Row(
            modifier = Modifier
                .width(145.dp)
                .padding(horizontal = 10.dp)
                .clip(RoundedCornerShape(12.dp))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = ripple(color = Color.Gray),
                    onClick = { viewModel.filtradoAnuladas(!viewModel.state.filtrarAnuladas) }
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = viewModel.state.filtrarAnuladas,
                onCheckedChange = { nuevoEstado -> viewModel.filtradoAnuladas(nuevoEstado) },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color(0xFF03592B),
                    checkedColor = Color(0xFF03592B)
                )
            )
            Text(
                text = "Anuladas"
            )
        }
        Row(
            modifier = Modifier
                .width(145.dp)
                .padding(horizontal = 10.dp)
                .clip(RoundedCornerShape(12.dp))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = ripple(color = Color.Gray),
                    onClick = { viewModel.filtradoCuotaFija(!viewModel.state.filtrarCuotaFjia) }
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = viewModel.state.filtrarCuotaFjia,
                onCheckedChange = { nuevoEstado -> viewModel.filtradoCuotaFija(nuevoEstado) },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color(0xFF03592B),
                    checkedColor = Color(0xFF03592B)
                )
            )
            Text(
                text = "Cuota fija"
            )
        }
    }
}

@Composable
fun BotonAplicarFiltros(onAplicarClick: () -> Unit) {
    Button(
        onClick = onAplicarClick,
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .width(300.dp)
            .height(55.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF24543B))
    ) {
        Text(
            text = "Aplicar filtros"
        )
    }
}

@Composable
fun BorrarFiltros(onBorrarClick: () -> Unit) {
    Button(
        onClick = onBorrarClick,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Gray
        ),
        modifier = Modifier.padding(top = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Borrar filtros",
                color = Color(0xFF24543B),
                textDecoration = TextDecoration.Underline
            )
        }
    }
}