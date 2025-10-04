package com.example.jetsat.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.jetsat.data.local.entities.Customer
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {

    @Upsert
     suspend fun insertCustomer(customer: Customer)

     @Query("DELETE FROM Customer WHERE id = :id")
     suspend fun  deleteCustomer(id:Int)

     @Query("SELECT * FROM Customer")
      fun getCustomer():Flow<List<Customer>>

}