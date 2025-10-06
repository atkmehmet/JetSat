package com.example.jetsat.domain.model

import androidx.room.PrimaryKey

data class InvoiceType(
    val id: Int = 0,
    val code: String,
    val name: String,
    val description: String? = null
){
    fun isValid():Boolean{
        return code.isNotEmpty() && name.isNotEmpty()
    }
}
