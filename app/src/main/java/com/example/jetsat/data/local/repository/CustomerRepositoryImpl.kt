package com.example.jetsat.data.local.repository

import com.example.jetsat.data.local.dao.CustomerDao
import com.example.jetsat.domain.model.Customer
import com.example.jetsat.domain.repository.CustomerRepository
import com.example.jetsat.mapper.toCustomer
import com.example.jetsat.mapper.toCustomerEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CustomerRepositoryImpl(
    private val customerDao: CustomerDao
):CustomerRepository {
    override suspend fun saveUpdateCustomer(customer: Customer) {
        customerDao.upsertCustomer(customer.toCustomerEntity())
    }

    override suspend fun deleteCustomer(customerId: Int) {
        customerDao.deleteCustomer(customerId)
    }

    override fun getCustomer(): Flow<List<Customer>> {
        return customerDao.getCustomers().map { customerentity->
            customerentity.map { it.toCustomer() }
        }
    }
}