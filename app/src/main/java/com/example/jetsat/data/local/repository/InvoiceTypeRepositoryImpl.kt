package com.example.jetsat.data.local.repository

import com.example.jetsat.data.local.dao.InvoiceTypeDao
import com.example.jetsat.domain.model.Invoice
import com.example.jetsat.domain.model.InvoiceType
import com.example.jetsat.domain.repository.InvoiceRepository
import com.example.jetsat.domain.repository.InvoiceTypeRepository
import com.example.jetsat.mapper.toInvoiceType
import com.example.jetsat.mapper.toInvoiceTypeEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class InvoiceTypeRepositoryImpl(private val invoiceTypeDao: InvoiceTypeDao):InvoiceTypeRepository {
    override suspend fun saveUpdateInvoiceType(invoiceType: InvoiceType) {
        invoiceTypeDao.upsertInvoiceType(invoiceType.toInvoiceTypeEntity())
    }

    override suspend fun deleteInvoiceType(invoiceTypeId: Int) {
        invoiceTypeDao.deleteInvoiceType(invoiceTypeId)
    }

    override fun getInvoiceType(): Flow<List<InvoiceType>> {
     return   invoiceTypeDao.getInvoiceTypes().map { invoiceTypeEntity ->
            invoiceTypeEntity.map {
                it.toInvoiceType()
            }
        }
    }

}
