package com.example.jetsat.mapper

import com.example.jetsat.data.local.entities.ProductMovementEntity
import com.example.jetsat.domain.model.ProductMovement


fun ProductMovement.toProductMovementEntity():ProductMovementEntity{
    return ProductMovementEntity(
        id = id,
        productId = productId,
        invoiceId = invoiceId,
        invoiceItemId = invoiceItemId,
        movementType = movementType,
        quantity = quantity,
        unitPrice = unitPrice,
        totalAmount = totalAmount,
        customerId = customerId,
        date = date,
        note = note,
        createdAt = createdAt
    )
}

fun ProductMovementEntity.toProductMovement():ProductMovement{
    return ProductMovement(
        id = id,
        productId = productId,
        invoiceId = invoiceId,
        invoiceItemId = invoiceItemId,
        movementType = movementType,
        quantity = quantity,
        unitPrice = unitPrice,
        totalAmount = totalAmount,
        customerId = customerId,
        date = date,
        note = note,
        createdAt = createdAt
    )
}