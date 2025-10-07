package com.example.jetsat.domain.repository

import com.example.jetsat.domain.model.Product
import kotlinx.coroutines.flow.Flow


interface ProductRepository {

    suspend fun saveUpdateProduct(product: Product)


    suspend fun deleteProduct(productId:Int)

    fun getProducts():Flow<List<Product>>
}