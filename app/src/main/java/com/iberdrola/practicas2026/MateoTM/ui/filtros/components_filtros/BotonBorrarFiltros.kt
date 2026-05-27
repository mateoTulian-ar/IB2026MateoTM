package com.iberdrola.practicas2026.MateoTM.ui.filtros.components_filtros

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

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