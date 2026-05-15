package com.iberdrola.practicas2026.MateoTM.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ValoracionDialog(onDismiss: () -> Unit){
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Volver", color = Color(0xFF2C692F))}
        },
        title = { },
        text = {
            Text("¡¡Gracias por su valoración!!",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 10.dp),
            fontWeight = FontWeight.Bold
            )
        }

    )
}