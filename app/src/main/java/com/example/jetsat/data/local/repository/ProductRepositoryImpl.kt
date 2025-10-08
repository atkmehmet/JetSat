package com.example.jetsat.data.local.repository

import com.example.jetsat.data.local.dao.ProductDao
import com.example.jetsat.domain.model.Product
import com.example.jetsat.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(
    private val productDao: ProductDao
):ProductRepository {
    override suspend fun saveUpdateProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProduct(productId: Int) {
        TODO("Not yet implemented")
    }

    override fun getProducts(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }
}