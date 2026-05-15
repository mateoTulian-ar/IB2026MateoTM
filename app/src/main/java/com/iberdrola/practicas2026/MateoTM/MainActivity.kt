package com.iberdrola.practicas2026.MateoTM

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.iberdrola.practicas2026.MateoTM.ui.listado_facturas.ListadoFacturasScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListadoFacturasScreen(
                viewModel = hiltViewModel(),
                onExitClick = {  }
            )
        }
    }
}



