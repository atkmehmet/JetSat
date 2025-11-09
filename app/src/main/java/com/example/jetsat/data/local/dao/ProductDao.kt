package com.example.jetsat.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert

import com.example.jetsat.data.local.entities.ProductEntity
import com.example.jetsat.data.local.model.ProductWithCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("DELETE  FROM ProductEntity where id= :productId")
    suspend fun  deleteProduct(productId:Int)
    
      @Upsert
      suspend fun addProduct(product: ProductEntity)

       @Query("SELECT * FROM ProductEntity")
       fun getProduct():Flow<List<ProductEntity>>

         @Transaction
        @Query("select * from ProductEntity")
        fun getProductCategory():Flow<List<ProductWithCategory>>


        @Query("SELECT * FROM ProductEntity WHERE productBarcode=:barcode")
        suspend fun getProductByBarcode(barcode:String):ProductEntity
}
