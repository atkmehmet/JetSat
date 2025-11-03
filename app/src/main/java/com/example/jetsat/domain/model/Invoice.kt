package com.example.jetsat.domain.model

import androidx.room.PrimaryKey

data class Invoice (
    val id: Int = 0,
    val date: Long = System.currentTimeMillis() ,
    val invoiceTypeId: String = "", //
    val customerName: String? = null,
    val totalPrice: Double = 0.0
    ){

    fun isValid ():Boolean{
        return date > 0 && invoiceTypeId.isNotEmpty() && (customerName?.isNotEmpty()
            ?: ("cari" + id)) as Boolean && totalPrice > 0
    }
}