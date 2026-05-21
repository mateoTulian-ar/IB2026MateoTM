package com.iberdrola.practicas2026.MateoTM.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun filtrosNoDisponibleDialog(onDismiss: () -> Unit){
    AlertDialog(
        containerColor = Color.White,
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(
                onClick = onDismiss,
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Gray
                ),
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            ) {
                Text(
                    text = "Salir",
                    color = Color(0xFF2C692F),
                    fontWeight = FontWeight.Bold
                )
            }
        },
        title = { Text("No disponible", color = Color.Black) },
        text = { Text("Los filtros de las facturas no están disponibles aún.", color = Color.DarkGray) }
    )
}