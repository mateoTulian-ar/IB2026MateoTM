package com.iberdrola.practicas2026.MateoTM.ui.listado_facturas.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LuzGasTabs(
    seleccionado: Int,
    onTab: (Int) -> Unit
){
    SecondaryScrollableTabRow(
        selectedTabIndex =  seleccionado,
        containerColor = Color.White,
        edgePadding = 5.dp,
        minTabWidth = 0.dp,
        indicator = {
            TabRowDefaults.SecondaryIndicator(
                Modifier
                    .tabIndicatorOffset(seleccionado)
                    .padding(horizontal = 10.dp),
                height = 5.dp,
                color = Color(0xFF096E19)
            )
        },
        // esta es la linea horizontal
        divider = {
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color(0xFF76BD79)
            )
        }
    ) {
        Tab(
            selected = seleccionado == 0,
            onClick = { onTab(0)},
            text = { Text("Luz", color = if(seleccionado == 0) Color.Black else Color.Gray) },
            modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
        Tab(
            selected = seleccionado == 1,
            onClick = { onTab(1)},
            text = { Text("Gas", color = if(seleccionado == 1) Color.Black else Color.Gray) },
            modifier = Modifier.clip(RoundedCornerShape(10.dp))
        )
    }
}