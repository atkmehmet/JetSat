package com.example.jetsat.domain.model

import androidx.room.PrimaryKey

data class Invoice (
    val id: Int = 0,
    val date: Long = System.currentTimeMillis() ,
    val type: String = "SALE", // "SALE", "PURCHASE", "RETURN"
    val customerName: String? = null,
    val totalPrice: Double = 0.0
    ){

    fun isValid ():Boolean{
        return date > 0 && type.isNotEmpty() && (customerName?.isNotEmpty()
            ?: ("cari" + id)) as Boolean && totalPrice > 0
    }
}