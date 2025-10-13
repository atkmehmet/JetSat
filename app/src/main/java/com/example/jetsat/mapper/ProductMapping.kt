package com.example.jetsat.mapper

import com.example.jetsat.data.local.entities.ProductEntity
import com.example.jetsat.domain.model.Product

fun Product.toProductEntity():ProductEntity{
    return ProductEntity(
        id = id,
        productName = productName,
        productTakePrice = productTakePrice,
        productSoldPrice = productSoldPrice,
        categoryId = id
    )
}

fun ProductEntity.toProduct():Product{
    return  Product(
        id = id,
        productName = productName,
        productTakePrice = productTakePrice,
        productSoldPrice = productSoldPrice,
        categoryId = id
    )
}