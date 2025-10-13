package com.example.jetsat.data.local.repository

import com.example.jetsat.data.local.dao.InvoiceDao
import com.example.jetsat.data.local.dao.InvoiceTypeDao
import com.example.jetsat.domain.model.Invoice
import com.example.jetsat.domain.repository.InvoiceRepository
import com.example.jetsat.mapper.toInvoice
import com.example.jetsat.mapper.toInvoiceEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class InvoiceRepositoryImpl(
    private val invoiceDao: InvoiceDao
):InvoiceRepository {
    override suspend fun saveUpdateInvoice(invoice: Invoice) {
        invoiceDao.upsertInvoice(invoice.toInvoiceEntity())
    }

    override suspend fun deleteInvoice(invoiceId: Int) {
        invoiceDao.deleteInvoice(invoiceId)
    }

    override fun getInvoice(): Flow<List<Invoice>> {
       return invoiceDao.getInvoices().map {
           invoiceEntityList-> invoiceEntityList.map {
               it.toInvoice()
       }
       }
    }
}