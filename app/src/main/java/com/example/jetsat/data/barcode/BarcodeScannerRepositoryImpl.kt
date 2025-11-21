package com.example.jetsat.data.barcode


import android.content.Context
import android.util.Log
import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageProxy
import com.example.jetsat.domain.repository.BarcodeScannerRepository
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
class BarcodeScannerRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : BarcodeScannerRepository {

    private val scanner = BarcodeScanning.getClient(
        BarcodeScannerOptions.Builder()
            .setBarcodeFormats(
                Barcode.FORMAT_CODE_128,
                Barcode.FORMAT_CODE_39,
                Barcode.FORMAT_EAN_13,
                Barcode.FORMAT_EAN_8,
                Barcode.FORMAT_UPC_A,
                Barcode.FORMAT_UPC_E,
                Barcode.FORMAT_QR_CODE
            )
            .build()
    )

    @OptIn(ExperimentalGetImage::class)
    override fun scanImage(imageProxy: ImageProxy, onDetected: (String) -> Unit) {

        val mediaImage = imageProxy.image
        if (mediaImage == null) {
            imageProxy.close()
            return
        }

        val image = InputImage.fromMediaImage(
            mediaImage,
            imageProxy.imageInfo.rotationDegrees
        )

        scanner.process(image)
            .addOnSuccessListener { barcodes ->
                for (barcode in barcodes) {
                    barcode.rawValue?.let { onDetected(it) }
                }
                imageProxy.close()    // ← burada kapatmak en doğru yer
            }
            .addOnFailureListener { e ->
                Log.e("BarcodeScanner", e.message ?: "Error")
                imageProxy.close()
            }
    }
}
