package com.example.jetsat.di

import android.content.Context
import androidx.room.Room
import com.example.jetsat.data.local.dao.CustomerDao
import com.example.jetsat.data.local.dao.InvoiceDao
import com.example.jetsat.data.local.dao.InvoiceTypeDao
import com.example.jetsat.data.local.dao.ProductDao
import com.example.jetsat.data.local.dao.ProductMovementDao
import com.example.jetsat.data.local.database.JetSatDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class JetSatDi {

    @Singleton
    @Provides
    fun createDatabase(@ApplicationContext context: Context):JetSatDatabase{

        return Room.databaseBuilder(
            context,
            JetSatDatabase::class.java,
            "jetsat.db"
        )
            .build()
           }

    @Provides
    @Singleton
    fun provideCustomerDao(db: JetSatDatabase): CustomerDao = db.customerDao()

    @Provides
    @Singleton
    fun provideInvoiceDao(db: JetSatDatabase): InvoiceDao = db.invoiceDao()

    @Provides
    @Singleton
    fun provideInvoiceTypeDao(db: JetSatDatabase): InvoiceTypeDao = db.invoiceTypeDao()

    @Provides
    @Singleton
    fun provideProductDao(db: JetSatDatabase): ProductDao = db.productDao()

    @Provides
    @Singleton
    fun provideProductMovementDao(db: JetSatDatabase): ProductMovementDao = db.productMovementDao()

}
