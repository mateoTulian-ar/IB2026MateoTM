package com.iberdrola.practicas2026.MateoTM.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
@Composable
fun facturasSkeleton() {
    val skeletonColor = Color(0xFFEBEBEB)
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.padding(start = 2.dp, top = 8.dp)
            ) {
                // Fecha
                Box(
                    modifier = Modifier
                        .padding(vertical = 6.dp)
                        .width(100.dp)
                        .height(18.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(skeletonColor)
                )
                
                // tipo de factura
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .height(14.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(skeletonColor)
                )
                
                // estado
                Box(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .height(30.dp)
                        .width(135.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(skeletonColor)
                )
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                // precio de la lista
                Box(
                    modifier = Modifier
                        .width(60.dp)
                        .height(16.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(skeletonColor)
                )
                
                Spacer(modifier = Modifier.width(8.dp))
                
                // la flecha
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(skeletonColor)
                )
            }
        }
        
        HorizontalDivider(
            modifier = Modifier.padding(top = 20.dp),
            color = Color(0xFFF0F0F0)
        )
    }
}

@Composable
fun historicoSkeleton(modifier: Modifier = Modifier) {
    val skeletonColor = Color(0xFFEBEBEB)
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // texto de histórico de facturas
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
                .height(40.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(skeletonColor)
        )
    }
}
@Composable
fun ultimaFacturaSkeleton(modifier: Modifier = Modifier) {
    val skeletonColor = Color(0xFFEBEBEB)
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(Color.White)
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
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(skeletonColor)
                )
            }
            
            // tipo de factura
            Box(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .width(80.dp)
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
                    .height(25.dp)
                    .width(135.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(skeletonColor)
            )
        }
    }
}
