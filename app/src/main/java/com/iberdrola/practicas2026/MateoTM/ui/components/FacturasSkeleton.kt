package com.iberdrola.practicas2026.MateoTM.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Composable
fun FacturasSkeleton() {
    val skeletonColor = Color(0xFFEBEBEB)
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Cuadro pequeño izquierda
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(skeletonColor)
                )

                Spacer(modifier = Modifier.width(12.dp))

                // Rectángulo largo
                Box(
                    modifier = Modifier
                        .width(160.dp)
                        .height(40.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(skeletonColor)
                )

                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(skeletonColor)
                )
            }
            HorizontalDivider(
                modifier = Modifier.padding(top = 16.dp),
                color = Color(0xFFF0F0F0)
            )
        }
    }
}
@Composable
fun HistoricoSkeleton(modifier: Modifier = Modifier) {
    val skeletonColor = Color(0xFFEBEBEB)
    Row(
        modifier = modifier.fillMaxWidth().padding(bottom = 35.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // historico de facturas
        Box(
            modifier = Modifier
                .width(180.dp)
                .height(22.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(skeletonColor)
        )

        Spacer(modifier = Modifier.weight(1f))
        // botón filtrar
        Box(
            modifier = Modifier
                .width(105.dp)
                .height(30.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(skeletonColor)
        )
    }
}
@Composable
fun UltimaFacturaSkeleton(modifier: Modifier = Modifier) {
    val skeletonColor = Color(0xFFEBEBEB)
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(2.dp, color = skeletonColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // título
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .height(20.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(skeletonColor)
                )
                Spacer(modifier = Modifier.weight(1f))
                // icono
                Box(
                    modifier = Modifier
                        .size(25.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(skeletonColor)
                )
            }
            
            // tipo de factura
            Box(
                modifier = Modifier
                    .width(300.dp)
                    .padding(top = 2.dp)
                    .height(14.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(skeletonColor)
            )

            Spacer(modifier = Modifier.height(15.dp))
            
            // precio
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(30.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(skeletonColor)
            )

            Spacer(modifier = Modifier.height(4.dp))
            
            // rango de fechas
            Box(
                modifier = Modifier
                    .width(180.dp)
                    .height(14.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(skeletonColor)
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 20.dp),
                color = Color(0xFFF0F0F0)
            )

            // estado
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(skeletonColor)
            )
        }
    }
}
