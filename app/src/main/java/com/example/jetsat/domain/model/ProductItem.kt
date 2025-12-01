package com.example.jetsat.domain.model
data class ProductItem(
    val product: Product,
    val quantity: Int = 1
) {
    val totalPrice: Double
        get() = product.productSoldPrice * quantity
}