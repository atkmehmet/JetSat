package com.example.jetsat.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.jetsat.data.local.entities.CustomerEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {

    @Upsert
     suspend fun upsertCustomer(customer: CustomerEntity)

     @Query("DELETE FROM CustomerEntity WHERE id = :customerId")
     suspend fun  deleteCustomer(customerId:Int)

     @Query("SELECT * FROM CustomerEntity")
      fun getCustomers():Flow<List<CustomerEntity>>

}