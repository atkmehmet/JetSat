package com.example.jetsat.domain.model

data class Product (
    val id : Int = 0,
    val productName:String,
    val productTakePrice:Double,
    val productSoldPrice:Double,
    val categoryId: Int
) {
    fun isValid(): Boolean {
        return productName.isNotBlank() &&
                productTakePrice > 0 &&
                productSoldPrice > 0 &&
                categoryId > 0
    }

}

