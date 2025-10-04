package com.example.jetsat.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.jetsat.data.local.entities.ProductWithCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductWithCategoryDao {


    @Upsert
    suspend fun upsertProductWithCategory(productWithCategoryDao: ProductWithCategoryDao)

    @Query("DELETE FROM ProductWithCategory where id= :productWithCategoryId")
    suspend fun deleteProductWithCategory(productWithCategoryId:Int)


    @Query("Select * from ProductWithCategory")
    fun getProductWithCategorys():Flow<List<ProductWithCategory>>
}