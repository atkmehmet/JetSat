package com.example.jetsat.data.local.repository

import com.example.jetsat.data.local.dao.ProductWithCategoryDao
import com.example.jetsat.domain.model.Category
import com.example.jetsat.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class CategoryRepositoryImpl(
    private val categoryDao: ProductWithCategoryDao
):CategoryRepository {
    override suspend fun saveUpdateCategory(category: Category) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCategory(categoryId: Int) {
        TODO("Not yet implemented")
    }

    override fun getCategoris(): Flow<List<Category>> {
        TODO("Not yet implemented")
    }
}