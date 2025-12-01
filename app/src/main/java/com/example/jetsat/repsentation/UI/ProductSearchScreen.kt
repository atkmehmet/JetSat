package com.example.jetsat.repsentation.UI

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.sp
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
    val productList by viewModel.productList.collectAsState()
    val isScannerOpen by viewModel.isScannerOpen.collectAsState()
    val code by viewModelBarcode.scannedCode.collectAsState()

    // Barkod okunduğunda işle
    LaunchedEffect(code) {
        if (code != null) {

            // ürünü bul
            viewModel.onBarcodeScanned(code ?: "")

            // ürün geldiyse listeye ekle
            viewModel.product.value?.let { product ->
                viewModel.addProductToList(product)
            }

            // kamera kapat
            viewModel.closeScanner()

            // barkodu temizle
            viewModelBarcode.resetScanner()

            // product temizle
            viewModel.onCleanProduct()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Barkod okuma butonu
            Button(
                onClick = {
                    viewModelBarcode.resetScanner()
                    viewModel.openScanner()
                }
            ) {
                Text("📷 Barkod Okut")
            }

            Spacer(Modifier.height(20.dp))

            // Ürün listesi
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(item = productList
                ,key =(it.id) ) { item ->

                    Card(
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(Modifier.padding(16.dp)) {

                            Text("Ürün: ${item.product.productName}", fontSize = 18.sp)
                            Text("Barkod: ${item.product.productBarcode}")
                            Text("Birim Fiyat: ${item.product.productSoldPrice} TL")

                            Spacer(Modifier.height(10.dp))

                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                // Adet azalt
                                Button(onClick = { viewModel.decreaseQuantity(item) }) {
                                    Text("-")
                                }

                                Text("Adet: ${item.quantity}", fontSize = 20.sp)

                                // Adet artır
                                Button(onClick = { viewModel.increaseQuantity(item) }) {
                                    Text("+")
                                }

                                // Silme butonu
                                Button(
                                    onClick = { viewModel.deleteProduct(item) },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                                ) {
                                    Text("Sil", color = Color.White)
                                }
                            }

                            Spacer(Modifier.height(10.dp))

                            Text(
                                "Toplam: ${item.totalPrice} TL",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Genel toplam
            Text(
                "Genel Toplam: ${viewModel.getTotalPrice()} TL",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
        }

        // Kamera alanı
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
