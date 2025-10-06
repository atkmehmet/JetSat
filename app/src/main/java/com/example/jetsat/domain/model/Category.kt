package com.example.jetsat.domain.model

import androidx.room.PrimaryKey

data class Category(
    val id: Int = 0,
    val categoryName: String
){
    fun isValid():Boolean{
        return categoryName.isNotEmpty()
    }
}
