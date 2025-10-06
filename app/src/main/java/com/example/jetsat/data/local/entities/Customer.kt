package com.example.jetsat.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CustomerEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val phone: String? = null,
    val email: String? = null,
    val address: String? = null
)
