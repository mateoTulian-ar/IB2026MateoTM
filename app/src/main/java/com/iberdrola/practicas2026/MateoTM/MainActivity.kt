package com.iberdrola.practicas2026.MateoTM

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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

            Row(
                modifier = Modifier.padding(horizontal = 25.dp, vertical = 30.dp).fillMaxWidth()
            ) {
                // tienen que ser botones creo..
                Text(
                    text = "Luz",
                    fontSize = 15.sp
                    // si se presiona se tiene que poner en negro...
                )

                Spacer(modifier = Modifier.width(30.dp))

                Text(
                    text = "Gas",
                    fontSize = 15.sp
                    // lo mismo
                )
            }
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
                tint = Color(0xFF4CAF5C),
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
                color = Color(0xFF4CAF5C)
            )

        }
    }

}