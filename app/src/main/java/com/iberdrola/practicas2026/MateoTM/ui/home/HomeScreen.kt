package com.iberdrola.practicas2026.MateoTM.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(onFacturasClick: () -> Unit){
    HomeContent(onFacturasClick = onFacturasClick)
}
@Composable
fun HomeContent(onFacturasClick: () -> Unit){
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Bienvenido a Iberdrola",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(
               onClick = onFacturasClick
            ) {
                Text(
                    text = "Ir a mis facturas",
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}