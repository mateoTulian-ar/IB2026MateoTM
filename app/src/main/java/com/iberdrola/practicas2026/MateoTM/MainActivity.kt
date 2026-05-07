package com.iberdrola.practicas2026.MateoTM

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FacturasScreen(exit = {  finish() })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FacturasScreen(exit: () -> Unit){


    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {  },
                navigationIcon = {
                    BotonSalir ( onExitClick = exit)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )

            )
        }

    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Text(
                text = "Mis Facturas",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "C/ Palma - ARTA KM 49,5,4ºA - PINTO - MADRID",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(15.dp))

            LuzGasTabs()







        }

    }
}


@Composable
fun BotonSalir(onExitClick: () -> Unit){

    TextButton(
        onClick = onExitClick
    ) {
        Row(
            verticalAlignment =  Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Outlined.ArrowBackIosNew,
                tint = Color(0xFF096E19),
                contentDescription = "Flecha para salir",
                modifier = Modifier.size(24.dp)
            )



            // Aca iría la flecha, pero no con el texto
            /*
            Text(
                text = "<",
                color = Color(0xFF4CAF5C),
                fontSize = 30.sp

            )

             */


            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Atrás",
                color = Color(0xFF096E19)
            )

        }
    }

}

@Composable
fun LuzGasTabs(){
    var opcionSeleccionada by remember { mutableIntStateOf(0) }

    // el Scrollable lo alinea a la izquierda
    SecondaryScrollableTabRow(
        selectedTabIndex =  opcionSeleccionada,
        containerColor = Color.White,
        edgePadding = 0.dp,
        minTabWidth = 0.dp,
        indicator = {
            TabRowDefaults.SecondaryIndicator(
                Modifier.tabIndicatorOffset(opcionSeleccionada)
                    .padding(horizontal = 12.dp),
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
            text = { Text("Gas", color = if(opcionSeleccionada == 1) Color.Black else Color.Gray) } // lo mismo de abajo
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    FacturasScreen(exit = {})
}