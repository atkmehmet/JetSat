package com.example.jetsat.mapper

import com.example.jetsat.data.local.entities.CategoryEntity
import com.example.jetsat.domain.model.Category

fun CategoryEntity.toCategory():Category{
    return Category(
        id = id,
        categoryName= categoryName,
    )
}

fun Category.toCategoryEntity():CategoryEntity{
    return CategoryEntity(
        id = id,
        categoryName = categoryName
    )
}