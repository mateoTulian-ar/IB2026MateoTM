package com.iberdrola.practicas2026.MateoTM.di

import android.content.Context
import co.infinum.retromock.Retromock
import com.iberdrola.practicas2026.MateoTM.network.FacturaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun crearFacturaApi(@ApplicationContext context: Context): FacturaApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api_falsa.com/") // le doy una url porque es obligatoria
            .addConverterFactory(GsonConverterFactory.create()) // lo convierto directamente a mi clase factura cuando recibo el json
            .build()

        val retromock = Retromock.Builder()
            .retrofit(retrofit) // usa el retrofit que cree arriba
            .defaultBodyFactory { context.assets.open(it) } // retromock no conoce nada entonces tengo que decirle donde ir a buscar el archivo
            .build()

        return retromock.create(FacturaApi::class.java)
    }
}