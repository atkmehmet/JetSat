package com.example.jetsat.domain.repository

import com.example.jetsat.domain.model.Customer
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {

    suspend fun saveUpdateCostomer(customer: Customer)

    suspend fun deleteCustomer(cutomerId:Int)

    fun getCutomer():Flow<List<Customer>>
}