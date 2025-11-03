package com.example.jetsat.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class InvoiceEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: Long,
    val invoiceTypeId: Int, // "SALE", "PURCHASE", "RETURN"
    val customerName: String? = null,
    val totalPrice: Double = 0.0
)
