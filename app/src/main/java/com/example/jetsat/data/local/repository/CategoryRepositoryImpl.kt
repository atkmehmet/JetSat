package com.example.jetsat.data.local.repository

import com.example.jetsat.data.local.dao.ProductWithCategoryDao
import com.example.jetsat.domain.model.Category
import com.example.jetsat.domain.repository.CategoryRepository
import com.example.jetsat.mapper.toCategory
import com.example.jetsat.mapper.toCategoryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CategoryRepositoryImpl(
    private val categoryDao: ProductWithCategoryDao
):CategoryRepository {
    override suspend fun saveUpdateCategory(category: Category) {
        categoryDao.upsertProductWithCategory(category.toCategoryEntity())
    }

    override suspend fun deleteCategory(categoryId: Int) {
        categoryDao.deleteProductWithCategory(categoryId)
    }

    override fun getCategoris(): Flow<List<Category>> {
        return categoryDao.getProductWithCategorys().map { entityList ->
            entityList.map { it.toCategory() }
        }
    }
}