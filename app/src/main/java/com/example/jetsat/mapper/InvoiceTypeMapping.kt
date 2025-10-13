package com.example.jetsat.mapper

import com.example.jetsat.data.local.entities.InvoiceTypeEntity
import com.example.jetsat.domain.model.InvoiceType

fun InvoiceTypeEntity.toInvoiceType():InvoiceType{
    return InvoiceType(
        id = id,
        code = code,
        name = name,
        description = description
    )
}

fun InvoiceType.toInvoiceTypeEntity():InvoiceTypeEntity{
    return InvoiceTypeEntity(
        id = id,
        code = code,
        name = name,
        description = description
    )
}