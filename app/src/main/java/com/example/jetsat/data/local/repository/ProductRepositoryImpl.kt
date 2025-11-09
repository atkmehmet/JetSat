package com.example.jetsat.data.local.repository

import com.example.jetsat.data.local.dao.ProductDao
import com.example.jetsat.data.local.entities.ProductEntity
import com.example.jetsat.domain.model.Product
import com.example.jetsat.domain.repository.ProductRepository
import com.example.jetsat.mapper.toProduct
import com.example.jetsat.mapper.toProductEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepositoryImpl(
    private val productDao: ProductDao
):ProductRepository {
    override suspend fun saveUpdateProduct(product: Product) {
        productDao.addProduct(product.toProductEntity())
    }

    override suspend fun deleteProduct(productId: Int) {
        productDao.deleteProduct(productId)
    }

    override suspend fun getProductByBarcode(barcode: String):Product {
      return  productDao.getProductByBarcode(barcode).toProduct()
    }

    override fun getProducts(): Flow<List<Product>> {
        return  productDao.getProduct().map {
            productEntityList-> productEntityList.map {
                it.toProduct()
        }
        }
    }
}