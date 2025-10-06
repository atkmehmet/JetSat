package com.example.jetsat.domain.model

import androidx.room.PrimaryKey

data class ProductMovement (
    val id: Int = 0,
    val productId: Int,
    val invoiceId: Int? = null,
    val invoiceItemId: Int? = null,
    val movementType: String, // "SALE", "PURCHASE", "RETURN_IN", "ADJUSTMENT" ...
    val quantity: Double,
    val unitPrice: Double,
    val totalAmount: Double,
    val customerId: Int? = null,
    val date: Long,
    val note: String? = null,
    val createdAt: Long = System.currentTimeMillis()
){
    fun isValid():Boolean{
        return productId>0 && invoiceId?:0>0 && invoiceItemId
    }
}