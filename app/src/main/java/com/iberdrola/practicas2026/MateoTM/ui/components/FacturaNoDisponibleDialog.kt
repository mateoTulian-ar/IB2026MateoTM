package com.iberdrola.practicas2026.MateoTM.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun facturaNoDisponibleDialog(onDismiss: () -> Unit){
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(
                onClick = onDismiss,
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Gray,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.LightGray
                )
            ) {
                Text(
                    text = "Salir",
                    color = Color(0xFF2C692F),
                    fontWeight = FontWeight.Bold
                )
            }
        },
        containerColor = Color.White,
        title = { Text("No disponible", color = Color.Black)},
        text = { Text("El detalle de la factura no está disponible aún.", color = Color.DarkGray)}
    )
}