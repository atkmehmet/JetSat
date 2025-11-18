package com.example.jetsat.repsentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsat.domain.model.Product
import com.example.jetsat.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class JetSatViewModel @Inject constructor(
    private val productRepository: ProductRepository
) :ViewModel() {

    private val _product = MutableStateFlow<Product>(Product())

    val product = _product.asStateFlow()

    private val _isScannerOpen = MutableStateFlow(false)
    val isScannerOpen = _isScannerOpen.asStateFlow()

    fun openScanner() {
        _isScannerOpen.value = true
    }

    fun closeScanner() {
        _isScannerOpen.value = false
    }

    fun onBarcodeScanned(barcode: String) {
        viewModelScope.launch {
        //    val found = productRepository.getProductByBarcode(barcode)
            _product.value = Product(
                productName = barcode
            )
            closeScanner()
        }
    }
}
