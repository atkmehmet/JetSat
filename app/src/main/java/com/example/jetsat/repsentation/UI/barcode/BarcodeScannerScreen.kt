package com.example.jetsat.repsentation.UI.barcode



import android.Manifest
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetsat.repsentation.ViewModel.BarcodeViewModel
import com.google.accompanist.permissions.*

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun BarcodeScannerScreen(
    viewModel: BarcodeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val permissionState = rememberPermissionState(Manifest.permission.CAMERA)

    val barcodeValue by viewModel.barcodeValue.collectAsState()
    val searchResults by viewModel.searchResults.collectAsState()

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Button(
            onClick = { permissionState.launchPermissionRequest() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📷 Barkod Oku")
        }

        Spacer(Modifier.height(12.dp))

        Text("Okunan Barkod: $barcodeValue")

        if (permissionState.status.isGranted) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
            ) {
                AndroidView(
                    factory = { ctx ->
                        val previewView = PreviewView(ctx)
                        val cameraProviderFuture = ProcessCameraProvider.getInstance(ctx)

                        cameraProviderFuture.addListener({
                            val cameraProvider = cameraProviderFuture.get()
                            val preview = Preview.Builder().build().apply {
                                setSurfaceProvider(previewView.surfaceProvider)
                            }

                            val imageAnalyzer = ImageAnalysis.Builder().build().apply {
                                setAnalyzer(
                                    ContextCompat.getMainExecutor(ctx)
                                ) { imageProxy ->
                                    viewModel.scanBarcode(imageProxy)
                                }
                            }

                            try {
                                cameraProvider.unbindAll()
                                cameraProvider.bindToLifecycle(
                                    lifecycleOwner,
                                    CameraSelector.DEFAULT_BACK_CAMERA,
                                    preview,
                                    imageAnalyzer
                                )
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }, ContextCompat.getMainExecutor(ctx))

                        previewView
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        } else {
            Text("Kamera izni gerekli", color = MaterialTheme.colorScheme.error)
        }

        Spacer(Modifier.height(16.dp))

        Text("Eşleşen Ürünler:", style = MaterialTheme.typography.titleMedium)
        searchResults.rEach { product ->
            Text("• ${product.name} (${product.barcode})")
        }
    }
}
