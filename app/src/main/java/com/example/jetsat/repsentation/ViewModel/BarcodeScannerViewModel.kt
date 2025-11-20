package com.example.jetsat.repsentation.ViewModel
import androidx.camera.core.ImageProxy
import androidx.lifecycle.ViewModel
import com.example.jetsat.domain.repository.BarcodeScannerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
@HiltViewModel
class BarcodeScannerViewModel @Inject constructor(
    private val barcodeScannerRepository: BarcodeScannerRepository
) : ViewModel() {

    private val _scannedCode = MutableStateFlow<String?>(null)
    val scannedCode = _scannedCode.asStateFlow()

    /**
     * Kamera tarafından gelen imageProxy burada taranır
     */
    fun scanBarcode(imageProxy: ImageProxy) {
        barcodeScannerRepository.scanImage(imageProxy) { code ->
            if (!code.isNullOrEmpty()) {
                _scannedCode.value = code
            }
        }
    }

    /**
     * Manuel barkod set etmek istersen
     */
    fun onBarcodeScanned(code: String) {
        _scannedCode.value = code
    }

    /**
     * Scanner her açıldığında mutlaka çağrılmalı
     */
    fun resetScanner() {
        _scannedCode.value = null
    }
}
