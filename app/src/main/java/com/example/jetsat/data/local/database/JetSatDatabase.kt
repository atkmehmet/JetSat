package com.example.jetsat.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetsat.data.local.dao.CustomerDao
import com.example.jetsat.data.local.dao.InvoiceDao
import com.example.jetsat.data.local.dao.InvoiceTypeDao
import com.example.jetsat.data.local.dao.ProductDao
import com.example.jetsat.data.local.dao.ProductMovementDao
import com.example.jetsat.data.local.dao.ProductWithCategoryDao
import com.example.jetsat.data.local.entities.Customer
import com.example.jetsat.data.local.entities.Invoice
import com.example.jetsat.data.local.entities.InvoiceType
import com.example.jetsat.data.local.entities.Product
import com.example.jetsat.data.local.entities.ProductMovement
import com.example.jetsat.data.local.entities.ProductWithCategory

@Database(entities = [Customer::class,
    Invoice::class,
    InvoiceType::class,
    Product::class,
    ProductMovement::class,
    ProductWithCategory::class], version = 1)
abstract class JetSatDatabase():RoomDatabase(){

    abstract fun customerDao():CustomerDao
    abstract fun invoiceDao():InvoiceDao
    abstract fun invoiceTypeDao():InvoiceTypeDao
    abstract fun productDao():ProductDao
    abstract fun productMovementDao():ProductMovementDao
    abstract fun productWithCategory():ProductWithCategoryDao

}
