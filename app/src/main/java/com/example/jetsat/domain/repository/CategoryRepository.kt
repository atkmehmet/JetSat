package com.example.jetsat.domain.repository

import com.example.jetsat.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface  CategoryRepository {

    suspend fun saveUpdateCategory(category: Category)


    suspend fun deleteCategory(categoryId:Int)


    fun getCategoris(): Flow<List<Category>>

}
