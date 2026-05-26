package com.iberdrola.practicas2026.MateoTM.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(onFacturasClick: () -> Unit) {
    HomeContent(onFacturasClick = onFacturasClick)
}

@Composable
fun HomeContent(onFacturasClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .statusBarsPadding() // para hacer que no se pegue arriba
            .padding(horizontal = 24.dp).padding(top = 10.dp)
    ) {
        Text(
            text = "Mis facturas",
            fontSize = 29.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF03592B),
            modifier = Modifier.padding(top = 20.dp)
        )
        Text(
            text = "Bienvenido a Iberdrola",
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = onFacturasClick, // te lleva a las facturas
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF03592B)
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Description,
                    contentDescription = "Icono Factura", // icono a la izquierda del texto
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Ver Facturas",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        // botón de notificaciones sin funcionamiento, solo visual
        Button(
            onClick = {},
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFF03592B)
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    tint = Color(0xFF03592B),
                    contentDescription = "Campanita",
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Configurar Notificaciones de Pago",
                    color = Color(0xFF03592B),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        // una tarjeta para aumentar un poco el diseño y que no quede la pantalla tan blanca
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFDBF1E5),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Eco, // Icono de una hoja
                    contentDescription = "Eco",
                    tint = Color(0xFF03592B),
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(14.dp))
                Column {
                    Text(
                        text = "Sabías que...",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF03592B)
                    )
                    Text(
                        text = "Activar la factura electrónica reduce el consumo de papel y ayuda a conservar nuestros bosques.",
                        fontSize = 13.sp,
                        color = Color(0xFF2C3E35),
                        lineHeight = 18.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(60.dp))
    }
}