package com.example.jetsat.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.jetsat.data.local.entities.CategoryEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface ProductWithCategoryDao {


    @Upsert
    suspend fun upsertProductWithCategory(productWithCategoryDao: ProductWithCategoryDao)

    @Query("DELETE FROM CategoryEntity where id= :productWithCategoryId")
    suspend fun deleteProductWithCategory(productWithCategoryId:Int)


    @Query("Select * from CategoryEntity")
    fun getProductWithCategorys():Flow<List<CategoryEntity>>
}