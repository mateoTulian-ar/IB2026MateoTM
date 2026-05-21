package com.iberdrola.practicas2026.MateoTM.di

import android.content.Context
import androidx.room.Room
import com.iberdrola.practicas2026.MateoTM.database.Database
import com.iberdrola.practicas2026.MateoTM.database.FacturaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object
DatabaseModule {
    @Provides // crea la db
    @Singleton // crea una única bd en toda la vida de la app
    fun crearBaseDeDatos(@ApplicationContext context: Context) : Database {
        var db = Room.databaseBuilder(context, Database::class.java, "facturas_db").build()
        return db
    }
    @Provides // crea un dao
    fun crearDao(db: Database) : FacturaDao {
        return db.facturaDao()
    }
}