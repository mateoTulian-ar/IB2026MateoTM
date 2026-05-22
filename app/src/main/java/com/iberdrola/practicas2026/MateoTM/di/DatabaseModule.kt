package com.iberdrola.practicas2026.MateoTM.di

import android.content.Context
import androidx.room.Room
import com.iberdrola.practicas2026.MateoTM.database.AppDatabase
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
    fun crearBaseDeDatos(@ApplicationContext context: Context): AppDatabase {
        var db = Room.databaseBuilder(context, klass = AppDatabase::class.java, name = "facturas_db")
            .fallbackToDestructiveMigration().build()
        return db
    }
    @Provides // crea un dao
    @Singleton
    fun crearDao(db: AppDatabase): FacturaDao {
        return db.facturaDao()
    }
}