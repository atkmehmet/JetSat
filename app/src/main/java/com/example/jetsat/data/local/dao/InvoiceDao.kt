package com.example.jetsat.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.jetsat.data.local.entities.Invoice
import kotlinx.coroutines.flow.Flow

@Dao
interface InvoiceDao {

    @Upsert
    suspend fun upsertInvoice(invoice: Invoice)

    @Query("DELETE FROM Invoice WHERE id = :invoiceId")
    suspend fun deleteInvoice(invoiceId:Int)

    @Query("Select * from Invoice")
    fun getInvoices(): Flow<List<Invoice>>

}