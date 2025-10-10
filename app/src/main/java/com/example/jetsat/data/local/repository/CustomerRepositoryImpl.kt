package com.example.jetsat.data.local.repository

import com.example.jetsat.data.local.dao.CustomerDao
import com.example.jetsat.domain.model.Customer
import com.example.jetsat.domain.repository.CustomerRepository
import kotlinx.coroutines.flow.Flow

class CustomerRepositoryImpl(
    private val customerDao: CustomerDao
):CustomerRepository {
    override suspend fun saveUpdateCustomer(customer: Customer) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCustomer(customerId: Int) {
        TODO("Not yet implemented")
    }

    override fun getCustomer(): Flow<List<Customer>> {
        TODO("Not yet implemented")
    }
}