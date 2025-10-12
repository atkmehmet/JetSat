package com.example.jetsat.data.local.repository

import com.example.jetsat.data.local.dao.InvoiceTypeDao
import com.example.jetsat.domain.model.Invoice
import com.example.jetsat.domain.model.InvoiceType
import com.example.jetsat.domain.repository.InvoiceRepository
import com.example.jetsat.domain.repository.InvoiceTypeRepository
import kotlinx.coroutines.flow.Flow

class InvoiceTypeRepositoryImpl(private val invoiceTypeDao: InvoiceTypeDao):InvoiceTypeRepository {
    override suspend fun saveUpdateInvoiceType(invoiceType: InvoiceType) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteInvoiceType(invoiceTypeId: Int) {
        TODO("Not yet implemented")
    }

    override fun getInvoiceType(): Flow<List<InvoiceType>> {
        TODO("Not yet implemented")
    }

}