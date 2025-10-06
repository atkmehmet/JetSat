package com.example.jetsat.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class InvoiceTypeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val code: String,
    val name: String,
    val description: String? = null
)
