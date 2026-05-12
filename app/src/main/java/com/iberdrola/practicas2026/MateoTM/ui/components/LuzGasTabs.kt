package com.iberdrola.practicas2026.MateoTM.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LuzGasTabs(){

    var opcionSeleccionada by remember { mutableIntStateOf(0) }

    // el Scrollable lo alinea a la izquierda
    SecondaryScrollableTabRow(
        selectedTabIndex =  opcionSeleccionada,
        containerColor = Color.White,
        edgePadding = 5.dp,
        minTabWidth = 0.dp,
        indicator = {
            TabRowDefaults.SecondaryIndicator(
                Modifier
                    .tabIndicatorOffset(opcionSeleccionada)
                    .padding(horizontal = 10.dp),
                height = 5.dp,
                color = Color(0xFF096E19)
            )


        },
        // esta es la linea horizontal gris
        divider = {
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color.LightGray,

                )
        }

    ) {


        Tab(
            selected = opcionSeleccionada == 0,
            onClick = { opcionSeleccionada = 0},
            text = { Text("Luz", color = if(opcionSeleccionada == 0) Color.Black else Color.Gray) } // si se pincha deberia ponerse en negro
        )

        Tab(
            selected = opcionSeleccionada == 1,
            onClick = { opcionSeleccionada = 1},
            text = { Text("Gas", color = if(opcionSeleccionada == 1) Color.Black else Color.Gray) } // lo mismo de arriba
        )

    }
}