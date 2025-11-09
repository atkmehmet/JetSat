package com.example.jetsat.mapper

import com.example.jetsat.data.local.entities.InvoiceEntity
import com.example.jetsat.domain.model.Invoice


fun Invoice.toInvoiceEntity():InvoiceEntity{
    return InvoiceEntity(
        id = id,
        date = date,
        invoiceTypeId = invoiceTypeId,
        customerName = customerName,
        totalPrice = totalPrice
    )
}

fun InvoiceEntity.toInvoice():Invoice{
    return Invoice(
        id = id,
        date = date,
        invoiceTypeId = invoiceTypeId,
        customerName = customerName,
        totalPrice = totalPrice
    )
}