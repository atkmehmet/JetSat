package com.example.jetsat.domain.repository

import androidx.room.Query
import androidx.room.Upsert
import com.example.jetsat.data.local.entities.ProductMovementEntity
import com.example.jetsat.domain.model.ProductMovement
import kotlinx.coroutines.flow.Flow

interface ProductMovementRepository {


    @Upsert
    suspend fun saveUpdateMovement(productMovement: ProductMovement)


    suspend fun saveUpdateMovement(productMovements: List<ProductMovement>)



    suspend fun deleteMovement(productMovementId: Int)



    fun getAllMovements(): Flow<List<ProductMovement>>



    fun getMovementsByProduct(productId: Int): Flow<List<ProductMovement>>



    fun getMovementsByInvoice(invoiceId: Int): Flow<List<ProductMovement>>



    fun getMovementsByCustomer(customerId: Int): Flow<List<ProductMovement>>



    fun getMovementsByType(type: String): Flow<List<ProductMovement>>

}