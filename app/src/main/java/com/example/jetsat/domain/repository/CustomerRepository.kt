package com.example.jetsat.domain.repository

import com.example.jetsat.domain.model.Customer
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {

    suspend fun saveUpdateCustomer(customer: Customer)

    suspend fun deleteCustomer(customerId:Int)

    fun getCustomer():Flow<List<Customer>>
}