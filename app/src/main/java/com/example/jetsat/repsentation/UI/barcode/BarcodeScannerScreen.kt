package com.example.app.presentation.barcode

import androidx.compose.ui.unit.dp
import com.example.jetsat.repsentation.ViewModel.BarcodeScannerViewModel


import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
@Composable
fun BarcodeScannerScreen(
    viewModelBarcode: BarcodeScannerViewModel = hiltViewModel(),
    onClose: () -> Unit,
    onScanned: (String) -> Unit
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    val code by viewModelBarcode.scannedCode.collectAsState()

    val previewView = remember { PreviewView(context) }

    val cameraProviderFuture = remember {
        ProcessCameraProvider.getInstance(context)
    }

    DisposableEffect(Unit) {

        val executor = ContextCompat.getMainExecutor(context)
        var cameraProvider: ProcessCameraProvider? = null

        cameraProviderFuture.addListener({
            cameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder().build().apply {
                setSurfaceProvider(previewView.surfaceProvider)
            }

            val analyzer = ImageAnalysis.Builder()
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()
                .apply {
                    setAnalyzer(executor) { imageProxy ->
                        viewModelBarcode.scanBarcode(imageProxy)
                        imageProxy.close()
                    }
                }

            try {
                cameraProvider?.unbindAll()
                cameraProvider?.bindToLifecycle(
                    lifecycleOwner,
                    CameraSelector.DEFAULT_BACK_CAMERA,
                    preview,
                    analyzer
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }, executor)

        onDispose {
            try {
                cameraProviderFuture.get().unbindAll()
            } catch (_: Exception) {}
        }
    }

    Box(Modifier.fillMaxSize()) {

        AndroidView(
            factory = { previewView },
            modifier = Modifier.fillMaxSize()
        )

        // Üstte kapatma tuşu
        IconButton(
            onClick = onClose,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Icon(Icons.Default.Close, contentDescription = "Close Camera")
        }
    }

    // barkod okununca ekran kapanır
    LaunchedEffect(code) {
        if (!code.isNullOrEmpty()) {
            onScanned(code!!)
            onClose()
        }
    }
}
