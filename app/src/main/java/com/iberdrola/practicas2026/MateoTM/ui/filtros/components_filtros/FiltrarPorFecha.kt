package com.iberdrola.practicas2026.MateoTM.ui.filtros.components_filtros

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FiltarPorFecha() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 25.dp)
    ) {
        Column() {
            Text(
                text = "* Desde",
                color = Color.Gray,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(200.dp))
            Icon(
                imageVector = Icons.Outlined.CalendarToday,
                contentDescription = "Calendario",
                modifier = Modifier
                    .offset(x = 140.dp, y = -15.dp)
                    .size(22.dp),
                tint = Color.Gray
            )

            HorizontalDivider(
                color = Color(0xFF5F6368),
                modifier = Modifier.width(165.dp),
                thickness = 2.dp
            )
        }
        Column() {
            Text(
                text = "* Hasta",
                color = Color.Gray,
                fontSize = 14.sp
            )
            Icon(
                imageVector = Icons.Outlined.CalendarToday,
                contentDescription = "Calendario",
                modifier = Modifier
                    .offset(x = 140.dp, y = -15.dp)
                    .size(22.dp),
                tint = Color.Gray
            )
            HorizontalDivider(
                color = Color(0xFF5F6368),
                modifier = Modifier.width(165.dp),
                thickness = 2.dp
            )
        }
    }
}