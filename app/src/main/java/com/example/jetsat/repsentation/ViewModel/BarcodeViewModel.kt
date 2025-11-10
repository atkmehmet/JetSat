package com.example.jetsat.repsentation.ViewModel


import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageProxy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsat.domain.model.Product
import com.example.jetsat.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage

@HiltViewModel
class BarcodeViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _barcodeValue = MutableStateFlow("")
    val barcodeValue = _barcodeValue.asStateFlow()

    private val _searchResults = MutableStateFlow<Product>(Product())
    val searchResults = _searchResults.asStateFlow()

    /**
     * Barkod tarama fonksiyonu
     */
    @OptIn(ExperimentalGetImage::class)
    fun scanBarcode(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            val scanner = BarcodeScanning.getClient()

            scanner.process(image)
                .addOnSuccessListener { barcodes ->
                    for (barcode in barcodes) {
                        barcode.rawValue?.let { value ->
                            _barcodeValue.value = value
                            searchProductByBarcode(value)
                        }
                    }
                }
                .addOnFailureListener { e ->
                    e.printStackTrace()
                }
                .addOnCompleteListener {
                    imageProxy.close()
                }
        } else {
            imageProxy.close()
        }
    }

    private fun searchProductByBarcode(barcode: String) {
        viewModelScope.launch {
            val products = productRepository.getProductByBarcode(barcode)
            _searchResults.value = products
        }
    }
}
