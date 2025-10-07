package com.example.jetsat.domain.repository

import com.example.jetsat.domain.model.Invoice
import kotlinx.coroutines.flow.Flow


interface InvoiceRepository {

    suspend fun  saveUpdateInvoice(invoice: Invoice)


    suspend fun deleteInvoice(invoiceId:Int)

    fun getInvoice():Flow<List<Invoice>>
}