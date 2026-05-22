package com.iberdrola.practicas2026.MateoTM.network

import co.infinum.retromock.meta.Mock
import co.infinum.retromock.meta.MockResponse
import com.iberdrola.practicas2026.MateoTM.model.Factura
import retrofit2.http.GET

interface FacturaApi {
    @Mock
    @MockResponse(body = "data/facturas.json")
    @GET("facturas")
    suspend fun obtenerFacturasRed(): Map<String, List<Factura>>
}