package com.example.jetsat.domain.model

import androidx.room.PrimaryKey

data class ProductMovement (
    val id: Int = 0,
    val productId: Int = 0,
    val invoiceId: Int? = null,
    val invoiceItemId: Int? = null,
    val movementType: String = "SALE" ,
    val quantity: Double = 0.0,
    val unitPrice: Double = 0.0,
    val totalAmount: Double = 0.0,
    val customerId: Int? = null,
    val date: Long = System.currentTimeMillis(),
    val note: String? = null,
    val createdAt: Long = System.currentTimeMillis()
){
    fun isValid():Boolean{
        return productId>0 && invoiceId?:0>0 && invoiceItemId?:0>0 && movementType.isNotEmpty() && quantity>0.0
                    &&  unitPrice>0.0 && customerId?:0>0
    }
}