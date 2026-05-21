package com.iberdrola.practicas2026.MateoTM.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun valoracionDialog(
    mensaje: String,
    onDismiss: () -> Unit
){
    LaunchedEffect(Unit) {
        delay(3000)
        onDismiss()
    }

    AlertDialog(
        containerColor = Color.White,
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(
                onClick = onDismiss,
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Gray
                ),
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            ) {
                Text(
                    text = "Cerrar",
                    color = Color(0xFF2C692F),
                    fontWeight = FontWeight.Bold
                )
            }
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