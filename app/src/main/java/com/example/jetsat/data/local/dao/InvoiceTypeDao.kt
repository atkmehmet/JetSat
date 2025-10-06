package com.example.jetsat.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

import com.example.jetsat.data.local.entities.InvoiceTypeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface InvoiceTypeDao {

    @Upsert
    suspend fun upsertInvoiceType(invoiceTypeDao: InvoiceTypeDao)

    @Query("Delete from InvoiceTypeEntity Where id=:invoiceTypeId")
     suspend fun  deleteInvoiceType(invoiceTypeId:Int)


     @Query("Select * from InvoiceTypeEntity")
     fun getInvoiceTypes():Flow<List<InvoiceTypeEntity>>
}