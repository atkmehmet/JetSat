package com.example.jetsat.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity= CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.SET_NULL
        )],
    indices = [Index("categoryId")]
)
data class ProductEntity(
   @PrimaryKey(autoGenerate = true) val id:Int,
    val productName:String,
    val productTakePrice:Double,
    val productSoldPrice:Double,
    val productBarcode:String,
    val categoryId: Int? = null
)
