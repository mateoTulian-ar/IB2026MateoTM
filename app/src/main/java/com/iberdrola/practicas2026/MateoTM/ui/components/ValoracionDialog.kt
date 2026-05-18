package com.iberdrola.practicas2026.MateoTM.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun ValoracionDialog(
    mensaje: String,
    onDismiss: () -> Unit
){

    // si el usuario no pulsa el salir tras 3 segundos se cierra
    LaunchedEffect(Unit) {
        delay(3000) // Lo subo un poco para que de tiempo a leer el mensaje dinámico
        onDismiss()
    }
    AlertDialog(
        containerColor = Color.White,
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Cerrar", color = Color(0xFF2C692F))}
        },
        title = { },
        text = {
            Text(
                text = mensaje,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 10.dp),
                fontWeight = FontWeight.Bold
            )
        }
    )
}