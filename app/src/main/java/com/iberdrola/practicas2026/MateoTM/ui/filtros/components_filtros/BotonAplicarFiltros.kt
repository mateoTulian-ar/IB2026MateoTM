package com.iberdrola.practicas2026.MateoTM.ui.filtros.components_filtros

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


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

