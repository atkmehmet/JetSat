package com.example.jetsat.mapper

import com.example.jetsat.data.local.entities.CustomerEntity
import com.example.jetsat.domain.model.Customer

fun Customer.toCustomerEntity():CustomerEntity{
    return CustomerEntity(
        id = id,
        name = name,
        phone = phone,
        email = email,
        address = address
    )
}
fun CustomerEntity.toCustomer():Customer{
    return  Customer(
        id = id,
        name = name,
        phone = phone?:"",
        email = email,
        address = address
    )
}