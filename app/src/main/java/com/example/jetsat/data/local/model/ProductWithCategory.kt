package com.example.jetsat.data.local.model

import androidx.room.Embedded
import androidx.room.Relation
import com.example.jetsat.data.local.entities.Product

data class ProductWithCategory(
    @Embedded val product: Product,

    @Relation(
        parentColumn = "categoryId",
        entityColumn = "id"
    )
    val category: ProductWithCategory

)
