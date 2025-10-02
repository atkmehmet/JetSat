package com.example.jetsat.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductWithCategory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val categoryName: String
)
