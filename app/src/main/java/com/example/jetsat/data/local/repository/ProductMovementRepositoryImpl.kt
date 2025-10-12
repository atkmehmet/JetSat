package com.example.jetsat.data.local.repository

import com.example.jetsat.data.local.dao.ProductMovementDao
import com.example.jetsat.data.local.entities.ProductMovementEntity
import com.example.jetsat.domain.model.ProductMovement
import com.example.jetsat.domain.repository.ProductMovementRepository
import kotlinx.coroutines.flow.Flow

class ProductMovementRepositoryImpl(
    private val productMovementDao: ProductMovementDao
):ProductMovementRepository {
    override suspend fun saveUpdateMovement(productMovement: ProductMovement) {
        TODO("Not yet implemented")
    }

    override suspend fun saveUpdateMovement(productMovements: List<ProductMovement>) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMovement(productMovementId: Int) {
        TODO("Not yet implemented")
    }

    override fun getAllMovements(): Flow<List<ProductMovementEntity>> {
        TODO("Not yet implemented")
    }

    override fun getMovementsByProduct(productId: Int): Flow<List<ProductMovement>> {
        TODO("Not yet implemented")
    }

    override fun getMovementsByInvoice(invoiceId: Int): Flow<List<ProductMovement>> {
        TODO("Not yet implemented")
    }

    override fun getMovementsByCustomer(customerId: Int): Flow<List<ProductMovement>> {
        TODO("Not yet implemented")
    }

    override fun getMovementsByType(type: String): Flow<List<ProductMovementEntity>> {
        TODO("Not yet implemented")
    }
}