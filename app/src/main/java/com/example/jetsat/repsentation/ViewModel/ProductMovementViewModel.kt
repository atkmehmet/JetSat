package com.example.jetsat.repsentation.ViewModel

import androidx.lifecycle.ViewModel
import com.example.jetsat.domain.model.Customer
import com.example.jetsat.domain.model.Invoice
import com.example.jetsat.domain.model.Product
import com.example.jetsat.domain.model.ProductMovement
import com.example.jetsat.domain.repository.CustomerRepository
import com.example.jetsat.domain.repository.InvoiceRepository
import com.example.jetsat.domain.repository.ProductMovementRepository
import com.example.jetsat.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class ProductMovementViewModel @Inject constructor (
    private val productMovementRepository: ProductMovementRepository,
    private val customerRepository: CustomerRepository,
    private val productRepository: ProductRepository,
    private val invoiceRepository: InvoiceRepository
):ViewModel() {

    private val _productList = MutableStateFlow<List<Product>>(emptyList())

    private  val _customerList = MutableStateFlow<List<Customer>>(emptyList())

    private val _invoiceList = MutableStateFlow<List<Invoice>>(emptyList())

    private val _productMovementList = MutableStateFlow<List<ProductMovement>>(emptyList())
}