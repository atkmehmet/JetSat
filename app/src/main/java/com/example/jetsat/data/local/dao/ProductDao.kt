package com.example.jetsat.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.jetsat.data.local.entities.Product
import com.example.jetsat.data.local.model.ProductWithCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("DELETE  FROM Product where id= :productId")
    suspend fun  deleteProduct(productId:Int)
    
      @Upsert
      suspend fun addProduct(product: Product)

       @Query("SELECT * FROM PRODUCT")
       fun getProduct():Flow<List<Product>>

         @Transaction
        @Query("select * from Product")
        fun getProductCategory():Flow<List<ProductWithCategory>>
}
