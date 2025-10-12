package com.example.jetsat.di

import android.content.Context
import androidx.room.Room
import com.example.jetsat.data.local.dao.CustomerDao
import com.example.jetsat.data.local.dao.InvoiceDao
import com.example.jetsat.data.local.dao.InvoiceTypeDao
import com.example.jetsat.data.local.dao.ProductDao
import com.example.jetsat.data.local.dao.ProductMovementDao
import com.example.jetsat.data.local.dao.ProductWithCategoryDao
import com.example.jetsat.data.local.database.JetSatDatabase
import com.example.jetsat.data.local.repository.CategoryRepositoryImpl
import com.example.jetsat.data.local.repository.CustomerRepositoryImpl
import com.example.jetsat.data.local.repository.InvoiceRepositoryImpl
import com.example.jetsat.data.local.repository.InvoiceTypeRepositoryImpl
import com.example.jetsat.data.local.repository.ProductMovementRepositoryImpl
import com.example.jetsat.data.local.repository.ProductRepositoryImpl
import com.example.jetsat.domain.repository.CategoryRepository
import com.example.jetsat.domain.repository.CustomerRepository
import com.example.jetsat.domain.repository.InvoiceRepository
import com.example.jetsat.domain.repository.InvoiceTypeRepository
import com.example.jetsat.domain.repository.ProductMovementRepository
import com.example.jetsat.domain.repository.ProductRepository
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

    @Provides
    fun provideProductRepository(productDao: ProductDao):ProductRepository{
        return ProductRepositoryImpl(productDao)
    }


    @Provides
    fun provideCustomerRepository(customerDao: CustomerDao):CustomerRepository{
        return CustomerRepositoryImpl(customerDao)
    }

    @Provides
    fun provideProductMovementRepository(productMovementDao: ProductMovementDao):ProductMovementRepository{
        return ProductMovementRepositoryImpl(productMovementDao)
    }

    @Provides
    fun provideInvoiceRepository(invoiceDao: InvoiceDao):InvoiceRepository{
        return InvoiceRepositoryImpl(invoiceDao)
    }

    @Provides
    fun provideInvoiceTypeRepository(invoiceTypeDao: InvoiceTypeDao):InvoiceTypeRepository{
        return InvoiceTypeRepositoryImpl(invoiceTypeDao)
    }

    @Provides
    fun provideCategoryRepository(categoryDao: ProductWithCategoryDao):CategoryRepository{

        return CategoryRepositoryImpl(categoryDao)
    }


}
