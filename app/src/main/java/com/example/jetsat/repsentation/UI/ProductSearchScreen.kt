package com.example.jetsat.repsentation.UI

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.app.presentation.barcode.BarcodeScannerScreen

import com.example.jetsat.repsentation.UI.barcode.CameraPermissionWrapper
import com.example.jetsat.repsentation.ViewModel.BarcodeScannerViewModel
import com.example.jetsat.repsentation.ViewModel.JetSatViewModel

@Composable
fun ProductSearchScreen(
    viewModel: JetSatViewModel = hiltViewModel(),
    viewModelBarcode: BarcodeScannerViewModel = hiltViewModel()
){

    val product by viewModel.product.collectAsState()
    val isScannerOpen by viewModel.isScannerOpen.collectAsState()
    val code by viewModelBarcode.scannedCode.collectAsState()

    // Barkod okunduğu anda kamera otomatik kapanır
    LaunchedEffect(code) {
        if (code != null) {
            viewModel.closeScanner()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                onClick = {
                    viewModelBarcode.resetScanner() // ← MUTLAKA TEMİZLE!
                    viewModel.openScanner()
                }
            ) {
                Text("📷 Barkod Read")
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (product != null) {
                Card(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    viewModel.onBarcodeScanned(code?:"")
                    Column(Modifier.padding(16.dp)) {
                        Text("Ürün Adı: ${product.productName}")
                        Text("Barkod: ${product!!.productBarcode}")
                        Text("Fiyat: ${product!!.productSoldPrice} tl")
                    }
                    viewModel.onCleanProduct()
                }
            } else {
                Text("Henüz ürün seçilmedi.")
            }
        }

        if (isScannerOpen) {
            CameraPermissionWrapper {
                BarcodeScannerScreen(
                    onClose = {
                        viewModel.closeScanner()
                    },
                    onScanned = { scanned ->
                        viewModelBarcode.onBarcodeScanned(scanned)
                    }
                )
            }
        }
    }
}
