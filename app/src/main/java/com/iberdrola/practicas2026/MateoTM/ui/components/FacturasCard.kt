package com.iberdrola.practicas2026.MateoTM.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.HorizontalDivider
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

@SuppressLint("DefaultLocale")
@Composable
fun FacturasCard(
    factura: Factura,
    onFacturaClick: () -> Unit
    ){
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onFacturaClick() },
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.padding(start = 2.dp, top = 8.dp)
            ) {
                Text(
                    text = formatearFechaListado(factura.fechaExpedicion),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 6.dp)
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
                        containerColor = if(factura.estado == "Pagada") Color(0xFFA6DAB4) else Color(0xFFE18F8F))
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = factura.estado,
                            textAlign = TextAlign.Center,
                            color = if(factura.estado == "Pagada") Color(0xFF075714) else Color(0xFF5E1414),
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
        HorizontalDivider(
            modifier = Modifier.padding(top = 20.dp),
            color = Color(0xFF70968B)
        )
    }
}