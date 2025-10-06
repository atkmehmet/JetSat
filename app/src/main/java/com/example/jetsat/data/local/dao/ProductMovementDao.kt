package com.example.jetsat.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

import com.example.jetsat.data.local.entities.ProductMovementEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductMovementDao {


    @Upsert
    suspend fun upsertMovement(movement: ProductMovementEntity)

    @Upsert
    suspend fun upsertMovements(movements: List<ProductMovementEntity>)


    @Query("DELETE FROM ProductMovementEntity WHERE id = :movementId")
    suspend fun deleteMovement(movementId: Int)


    @Query("SELECT * FROM ProductMovementEntity ORDER BY date DESC")
    fun getAllMovements(): Flow<List<ProductMovementEntity>>


    @Query("SELECT * FROM ProductMovementEntity WHERE productId = :productId ORDER BY date DESC")
    fun getMovementsByProduct(productId: Int): Flow<List<ProductMovementEntity>>


    @Query("SELECT * FROM ProductMovementEntity WHERE invoiceId = :invoiceId ORDER BY date DESC")
    fun getMovementsByInvoice(invoiceId: Int): Flow<List<ProductMovementEntity>>


    @Query("SELECT * FROM ProductMovementEntity WHERE customerId = :customerId ORDER BY date DESC")
    fun getMovementsByCustomer(customerId: Int): Flow<List<ProductMovementEntity>>


    @Query("SELECT * FROM ProductMovementEntity WHERE movementType = :type ORDER BY date DESC")
    fun getMovementsByType(type: String): Flow<List<ProductMovementEntity>>


    @Query("SELECT * FROM ProductMovementEntity WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    fun getMovementsByDateRange(startDate: Long, endDate: Long): Flow<List<ProductMovementEntity>>
}
