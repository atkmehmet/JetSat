package com.example.jetsat.data.local.repository

import com.example.jetsat.data.local.dao.ProductMovementDao
import com.example.jetsat.data.local.entities.ProductMovementEntity
import com.example.jetsat.domain.model.ProductMovement
import com.example.jetsat.domain.repository.ProductMovementRepository
import com.example.jetsat.mapper.toProductMovement
import com.example.jetsat.mapper.toProductMovementEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductMovementRepositoryImpl(
    private val productMovementDao: ProductMovementDao
):ProductMovementRepository {
    override suspend fun saveUpdateMovement(productMovement: ProductMovement) {
        productMovementDao.upsertMovement(productMovement.toProductMovementEntity())
    }

    override suspend fun saveUpdateMovement(productMovements: List<ProductMovement>) {
         productMovementDao.upsertMovements(productMovements.map {
             productList->productList.toProductMovementEntity()
         })
    }

    override suspend fun deleteMovement(productMovementId: Int) {
        productMovementDao.deleteMovement(productMovementId)
    }

    override fun getAllMovements(): Flow<List<ProductMovement>> {
        return productMovementDao.getAllMovements().map { productEntityList->
            productEntityList.map {
                it.toProductMovement()
            }
        }
    }

    override fun getMovementsByProduct(productId: Int): Flow<List<ProductMovement>> {
     return   productMovementDao.getMovementsByProduct(productId).map {
         productEntityList->productEntityList.map {
             it.toProductMovement()
     }
     }
    }

    override fun getMovementsByInvoice(invoiceId: Int): Flow<List<ProductMovement>> {
        return productMovementDao.getMovementsByInvoice(invoiceId).map {
            productEntityList-> productEntityList.map {
                it.toProductMovement()
        }
        }
    }

    override fun getMovementsByCustomer(customerId: Int): Flow<List<ProductMovement>> {
        return productMovementDao.getMovementsByCustomer(customerId).map {
            productEntityList-> productEntityList.map {
                it.toProductMovement()
        }
        }
    }

    override fun getMovementsByType(type: String): Flow<List<ProductMovement>> {
        return  productMovementDao.getMovementsByType(type).map {
            productEntityList-> productEntityList.map {
                it.toProductMovement()
        }
        }
    }
}