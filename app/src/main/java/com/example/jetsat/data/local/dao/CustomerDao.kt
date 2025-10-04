package com.example.jetsat.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.jetsat.data.local.entities.Customer
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {

    @Upsert
     suspend fun upsertCustomer(customer: Customer)

     @Query("DELETE FROM Customer WHERE id = :customerId")
     suspend fun  deleteCustomer(customerId:Int)

     @Query("SELECT * FROM Customer")
      fun getCustomers():Flow<List<Customer>>

}