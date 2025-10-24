package com.example.jetsat.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetsat.data.local.dao.CategoryDao
import com.example.jetsat.data.local.dao.CustomerDao
import com.example.jetsat.data.local.dao.InvoiceDao
import com.example.jetsat.data.local.dao.InvoiceTypeDao
import com.example.jetsat.data.local.dao.ProductDao
import com.example.jetsat.data.local.dao.ProductMovementDao
import com.example.jetsat.data.local.entities.CategoryEntity

import com.example.jetsat.data.local.entities.CustomerEntity

import com.example.jetsat.data.local.entities.InvoiceEntity
import com.example.jetsat.data.local.entities.InvoiceTypeEntity
import com.example.jetsat.data.local.entities.ProductEntity

import com.example.jetsat.data.local.entities.ProductMovementEntity

@Database(entities = [CustomerEntity::class,
    InvoiceEntity::class,
    InvoiceTypeEntity::class,
    ProductEntity::class,
    ProductMovementEntity::class,
    CategoryEntity::class], version = 1)
abstract class JetSatDatabase():RoomDatabase(){

    abstract fun customerDao():CustomerDao
    abstract fun invoiceDao():InvoiceDao
    abstract fun invoiceTypeDao():InvoiceTypeDao
    abstract fun productDao():ProductDao
    abstract fun productMovementDao():ProductMovementDao
    abstract fun productWithCategory(): CategoryDao

}
