package com.example.jetsat.data.local.repository

import com.example.jetsat.data.local.dao.InvoiceTypeDao
import com.example.jetsat.domain.model.Invoice
import com.example.jetsat.domain.repository.InvoiceRepository
import kotlinx.coroutines.flow.Flow

class InvoiceTypeRepositoryImpl(private val invoiceTypeDao: InvoiceTypeDao):InvoiceRepository {
    override suspend fun saveUpdateInvoice(invoice: Invoice) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteInvoice(invoiceId: Int) {
        TODO("Not yet implemented")
    }

    override fun getInvoice(): Flow<List<Invoice>> {
        TODO("Not yet implemented")
    }
}