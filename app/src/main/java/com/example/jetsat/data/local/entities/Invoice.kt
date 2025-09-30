package com.example.jetsat.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Invoice(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: Long,
    val type: String, // "SALE", "PURCHASE", "RETURN"
    val customerName: String? = null, // isteğe bağlı
    val totalPrice: Double = 0.0
)
