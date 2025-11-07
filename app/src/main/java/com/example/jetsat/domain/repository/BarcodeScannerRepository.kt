package com.example.jetsat.domain.repository

import androidx.camera.core.ImageProxy

interface BarcodeScannerRepository {
    fun scanImage(imageProxy: ImageProxy, onDetected: (String) -> Unit)
}