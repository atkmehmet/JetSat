package com.example.jetsat.domain.model

import androidx.room.PrimaryKey

data class Customer(
    val id: Int = 0,
    val name: String,
    val phone: String = "",
    val email: String? = null,
    val address: String? = null
){
    fun isValid():Boolean{
        return name.isNotBlank() && phone.isNotBlank()
    }
}
