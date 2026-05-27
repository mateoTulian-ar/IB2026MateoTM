package com.iberdrola.practicas2026.MateoTM.ui.filtros.components_filtros

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.iberdrola.practicas2026.MateoTM.ui.filtros.FiltrosViewModel


@Composable
fun FiltrarPorEstado(viewModel: FiltrosViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .width(145.dp)
                .padding(horizontal = 10.dp)
                .clip(RoundedCornerShape(30.dp))
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
                .clip(RoundedCornerShape(30.dp))
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
                .clip(RoundedCornerShape(30.dp))
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
                .clip(RoundedCornerShape(30.dp))
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
                .clip(RoundedCornerShape(30.dp))
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
