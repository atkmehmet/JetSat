package com.example.jetsat.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
   @PrimaryKey(autoGenerate = true) val id:Int,
    val productName:String,
    val productTakePrice:Double,
    val productSoldPrice:Double

)
