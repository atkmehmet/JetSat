package com.example.jetsat.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = ["id"],
            childColumns = ["productId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Invoice::class,
            parentColumns = ["id"],
            childColumns = ["invoiceId"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = Customer::class,
            parentColumns = ["id"],
            childColumns = ["customerId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [Index("productId"), Index("invoiceId"), Index("customerId")]
)
data class ProductMovement(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
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
)

