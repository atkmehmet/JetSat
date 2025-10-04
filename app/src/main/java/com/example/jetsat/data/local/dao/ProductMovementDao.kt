package com.example.jetsat.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.jetsat.data.local.entities.ProductMovement
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductMovementDao {


    @Upsert
    suspend fun upsertMovement(movement: ProductMovement)

    @Upsert
    suspend fun upsertMovements(movements: List<ProductMovement>)


    @Query("DELETE FROM ProductMovement WHERE id = :movementId")
    suspend fun deleteMovement(movementId: Int)


    @Query("SELECT * FROM ProductMovement ORDER BY date DESC")
    fun getAllMovements(): Flow<List<ProductMovement>>


    @Query("SELECT * FROM ProductMovement WHERE productId = :productId ORDER BY date DESC")
    fun getMovementsByProduct(productId: Int): Flow<List<ProductMovement>>


    @Query("SELECT * FROM ProductMovement WHERE invoiceId = :invoiceId ORDER BY date DESC")
    fun getMovementsByInvoice(invoiceId: Int): Flow<List<ProductMovement>>


    @Query("SELECT * FROM ProductMovement WHERE customerId = :customerId ORDER BY date DESC")
    fun getMovementsByCustomer(customerId: Int): Flow<List<ProductMovement>>


    @Query("SELECT * FROM ProductMovement WHERE movementType = :type ORDER BY date DESC")
    fun getMovementsByType(type: String): Flow<List<ProductMovement>>


    @Query("SELECT * FROM ProductMovement WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    fun getMovementsByDateRange(startDate: Long, endDate: Long): Flow<List<ProductMovement>>
}
