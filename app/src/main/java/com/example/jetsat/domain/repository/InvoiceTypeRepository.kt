package com.example.jetsat.domain.repository

import com.example.jetsat.domain.model.InvoiceType
import kotlinx.coroutines.flow.Flow

interface InvoiceTypeRepository {


    suspend fun  saveUpdateInvoiceType(invoiceType: InvoiceType)

    suspend fun deleteInvoiceType(invoiceTypeId:Int)

    fun getInvoiceType():Flow<List<InvoiceType>>
}