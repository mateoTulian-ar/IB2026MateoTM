package com.iberdrola.practicas2026.MateoTM.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iberdrola.practicas2026.MateoTM.ui.home.components_home.IrAMiFacturas
import com.iberdrola.practicas2026.MateoTM.ui.home.components_home.NotificacionesDePago
import com.iberdrola.practicas2026.MateoTM.ui.home.components_home.TarjetaInfo

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
        IrAMiFacturas(onFacturasClick = onFacturasClick)
        // botón de notificaciones sin funcionamiento, solo visual
        NotificacionesDePago()
        Spacer(modifier = Modifier.weight(1f))
        // una tarjeta para aumentar un poco el diseño y que no quede la pantalla tan blanca
        TarjetaInfo()
        Spacer(modifier = Modifier.height(60.dp))
    }
}