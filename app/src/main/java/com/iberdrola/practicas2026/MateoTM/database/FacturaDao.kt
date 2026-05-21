package com.iberdrola.practicas2026.MateoTM.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iberdrola.practicas2026.MateoTM.model.Factura
import kotlinx.coroutines.flow.Flow

@Dao
interface FacturaDao {
    @Query(value = "select * from Factura")
    fun obtenerFacturas() : Flow<List<Factura>> // el flow sirve para que sea reactiva, es decir que no se tenga que volver a llamar a cada rato si por ejemplo los datos cmbian

    @Insert(onConflict = OnConflictStrategy.REPLACE) // si se inserta un registro con el mismo id, borra el viejo
    suspend fun insertFactura(facturas: List<Factura>)
}