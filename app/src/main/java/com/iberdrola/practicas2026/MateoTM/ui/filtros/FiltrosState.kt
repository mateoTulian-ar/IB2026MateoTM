package com.iberdrola.practicas2026.MateoTM.ui.filtros

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SliderState
import kotlin.math.max

data class FiltrosState @OptIn(ExperimentalMaterial3Api::class) constructor(
    val minValorSlider: Float = 0f, // solo lo incializo, despues lo cambio con el  valor mas bajo y mas alto
    val maxValorSlider: Float = 0f,
    val rangoPrecio: ClosedFloatingPointRange<Float> = minValorSlider..maxValorSlider, // un principio y un fin obligatorio
    val filtrarPagadas: Boolean = false,
    val filtrarPendientes: Boolean = false,
    val filtrarEnTramite: Boolean = false,
    val filtrarAnuladas: Boolean = false,
    val filtrarCuotaFjia: Boolean = false,
    val sliderMinimo: MutableInteractionSource = MutableInteractionSource(),
    val sliderMaximo: MutableInteractionSource = MutableInteractionSource()
)
