package com.example.jetsat.data.barcode

import android.content.Context
import android.util.Log
import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageProxy
import com.example.jetsat.domain.repository.BarcodeScannerRepository
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class BarcodeScannerRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : BarcodeScannerRepository {

    private val scanner = BarcodeScanning.getClient()

    @OptIn(ExperimentalGetImage::class)
    override fun scanImage(imageProxy: ImageProxy, onDetected: (String) -> Unit) {

        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            scanner.process(image)
                .addOnSuccessListener { barcodes ->
                    for (barcode in barcodes) {
                        barcode.rawValue?.let { onDetected(it) }
                    }
                }
                .addOnFailureListener { Log.e("BarcodeScanner", it.message ?: "Error") }
                .addOnCompleteListener { imageProxy.close() }
        } else {
            imageProxy.close()
        }
    }
}