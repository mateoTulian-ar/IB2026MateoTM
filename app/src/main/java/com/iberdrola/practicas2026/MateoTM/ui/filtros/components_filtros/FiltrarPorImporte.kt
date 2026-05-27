package com.iberdrola.practicas2026.MateoTM.ui.filtros.components_filtros

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iberdrola.practicas2026.MateoTM.ui.filtros.FiltrosViewModel

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
