package com.iberdrola.practicas2026.MateoTM.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun FiltrosNoDisponibleDialog(onDismiss: () -> Unit){
    AlertDialog(
        containerColor = Color.White,
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Salir", color = Color(0xFF2C692F)) }
        },
        title = { Text("No disponible") },
        text = { Text("Los filtros de la factura no está disponible aún, vuelve mas tarde.") }
    )
}