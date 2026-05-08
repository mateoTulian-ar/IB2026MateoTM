package com.iberdrola.practicas2026.MateoTM.ui.listado_facturas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.lang.System.exit

@Composable
fun ListadoFacturasScreen(
    viewmodel: ListadoFacturasViewModel,
    onExitClick: () -> Unit
){
    ListadoFacturasContent(onExitClick)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListadoFacturasContent(
    onExitClick: () -> Unit
){
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {  },
                navigationIcon = {
                    BotonSalir ( onExitClick = onExitClick)
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
            Cabecera(direccion = "C/ Palma - ARTA KM 49,5,4ºA - PINTO - MADRID")

            Spacer(modifier = Modifier.height(15.dp))
            LuzGasTabs()

            Spacer(modifier = Modifier.height(5.dp))
            UltimaFactura()

            Spacer(modifier = Modifier.height(25.dp))
            Historico()


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
        edgePadding = 5.dp,
        minTabWidth = 0.dp,
        indicator = {
            TabRowDefaults.SecondaryIndicator(
                Modifier.tabIndicatorOffset(opcionSeleccionada)
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
            text = { Text("Gas", color = if(opcionSeleccionada == 1) Color.Black else Color.Gray) } // lo mismo de abajo
        )

    }
}

@Composable
fun Cabecera(direccion: String){
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
        text = direccion,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun UltimaFactura(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, color = Color(0xFF096E19)),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 15.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Última factura",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Outlined.Lightbulb,
                    tint = Color(0xFF096E19),
                    contentDescription = "Bombilla",
                    modifier = Modifier.size(40.dp).offset(y = 10.dp)


                )
            }

            //Spacer(modifier = Modifier.padding(vertical = 1.dp))
            Text(text = "Factura Luz")

            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "30,00 ",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "€",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }


            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "01 feb. 2024 - 04 mar.2024")

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 20.dp),
                color = Color(0xFF70968B)
            )

            Card(
                modifier = Modifier.height(30.dp).width(135.dp),
                colors = CardDefaults.cardColors(Color(0xFFE18F8F))
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                        text = "Pendiente de pago",
                        textAlign = TextAlign.Center,
                        color = Color(0xFF5E1414),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun Historico(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)
    ) {
        Text(
            text = "Histórico de facturas",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        Card(
            modifier = Modifier
                .width(105.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(20.dp))
                .clickable { },
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(2.dp, color = Color(0xFF096E19)),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Outlined.Tune,
                    tint = Color(0xFF096E19),
                    contentDescription = "Filtros",
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 7.dp)
                )
                Text(
                    text = "Filtrar",
                    color = Color(0xFF096E19),
                    fontWeight = FontWeight.Bold

                )
            }

        }
    }

}



@Preview(showBackground = true)
@Composable
fun Preview(){
    ListadoFacturasContent { }
}