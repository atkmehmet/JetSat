package com.example.jetsat.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.jetsat.data.local.entities.CategoryEntity
import com.example.jetsat.domain.model.Category

import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {


    @Upsert
    suspend fun upsertProductWithCategory(category: CategoryEntity)

    @Query("DELETE FROM CategoryEntity where id= :productWithCategoryId")
    suspend fun deleteProductWithCategory(productWithCategoryId:Int)


    @Query("Select * from CategoryEntity")
    fun getProductWithCategorys():Flow<List<CategoryEntity>>
}