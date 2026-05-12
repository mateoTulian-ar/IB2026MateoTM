package com.iberdrola.practicas2026.MateoTM.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iberdrola.practicas2026.MateoTM.model.Factura
import com.iberdrola.practicas2026.MateoTM.utils.formatearFechaListado

@Composable
fun FacturasCard(factura: Factura){
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.padding(start = 2.dp)
            ) {
                Text(
                    text = formatearFechaListado(factura.fechaExpedicion),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = "Factura ${factura.tipo}"
                )
                Card(
                    modifier = Modifier
                        .height(30.dp)
                        .width(135.dp)
                        .padding(top = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if(factura.estado == "Pagada") Color(0xFFB2D7BA) else Color(0xFFE18F8F))
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = factura.estado,
                            textAlign = TextAlign.Center,
                            color = if(factura.estado == "Pagada") Color(0xFF096E19) else Color(0xFF5E1414),
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = "${String.format("%.2f", factura.valor)} €",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                Icon(
                    imageVector = Icons.Outlined.ChevronRight,
                    tint = Color.Gray,
                    contentDescription = "Flecha",
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}