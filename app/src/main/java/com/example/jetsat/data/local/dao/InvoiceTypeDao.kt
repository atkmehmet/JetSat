package com.example.jetsat.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.jetsat.data.local.entities.InvoiceType
import kotlinx.coroutines.flow.Flow

@Dao
interface InvoiceTypeDao {

    @Upsert
    suspend fun upsertInvoiceType(invoiceTypeDao: InvoiceTypeDao)

    @Query("Delete from InvoiceType Where id=:invoiceTypeId")
     suspend fun  deleteInvoiceType(invoiceTypeId:Int)


     @Query("Select * from InvoiceType")
     fun getInvoiceTypes():Flow<List<InvoiceType>>
}