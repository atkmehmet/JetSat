package com.example.jetsat.domain.model

data class Product (
    val id : Int = 0,
    val productName:String = "",
    val productTakePrice:Double = 0.0,
    val productSoldPrice:Double = 0.0,
    val categoryId: Int = 0
) {
    fun isValid(): Boolean {
        return productName.isNotBlank() &&
                productTakePrice > 0 &&
                productSoldPrice > 0 &&
                categoryId > 0
    }

}

