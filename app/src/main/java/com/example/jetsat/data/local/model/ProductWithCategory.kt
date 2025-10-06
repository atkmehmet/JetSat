package com.example.jetsat.data.local.model

import androidx.room.Embedded
import androidx.room.Relation
import com.example.jetsat.data.local.entities.ProductEntity

data class ProductWithCategory(
@Embedded val product: ProductEntity,

    @Relation(
        parentColumn = "categoryId",
        entityColumn = "id"
    )
    val category: ProductWithCategory

)
