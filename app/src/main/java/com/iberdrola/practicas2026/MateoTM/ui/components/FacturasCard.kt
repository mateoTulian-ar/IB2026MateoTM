package com.iberdrola.practicas2026.MateoTM.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material3.ripple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iberdrola.practicas2026.MateoTM.model.Factura
import com.iberdrola.practicas2026.MateoTM.utils.FormatearFechaListado

@SuppressLint("DefaultLocale")
@Composable
fun FacturasCard(
    factura: Factura,
    onFacturaClick: () -> Unit
    ){
    Card(
        modifier = Modifier.fillMaxWidth()
            .clip(shape = RoundedCornerShape(size = 12.dp) )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(color = Color.Gray),
                onClick = onFacturaClick
            )
            .padding(horizontal = 18.dp),
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
                    text = FormatearFechaListado(factura.fechaExpedicion),
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
                        .padding(top = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = when(factura.estado) {
                            "Pagada" -> Color(0xFFA6DAB4)
                            "Anulada" -> Color(0xFFD1D1D1)
                            "En trámite de cobro" -> Color(0xFFFFE5D0)
                            "Cuota fija" -> Color(0xFFC7E2F1)
                            else -> Color(0xFFE18F8F)
                        }
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(horizontal = 12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = factura.estado, // dependiente que estado se pone el tipo y el color
                            textAlign = TextAlign.Center,
                            color = when(factura.estado) {
                                "Pagada" -> Color(0xFF075714)
                                "Anulada" -> Color(0xFF4A4A4A)
                                "En trámite de cobro" -> Color(0xFFB35A00)
                                "Cuota fija" -> Color(0xFF0C4E72)
                                else -> Color(0xFF5E1414)
                            },
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
                    text = "${String.format("%.2f", factura.valor)} €", // lo reduzco a 2 decimales obligatoriamente
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