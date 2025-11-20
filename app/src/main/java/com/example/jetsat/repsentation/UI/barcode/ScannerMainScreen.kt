package com.example.jetsat.repsentation.UI.barcode



import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.app.presentation.barcode.BarcodeScannerScreen
import com.example.jetsat.repsentation.ViewModel.BarcodeScannerViewModel


@Composable
fun ScannerMainScreen(
    viewModel: BarcodeScannerViewModel = hiltViewModel()
) {
    val code by viewModel.scannedCode.collectAsState()

    CameraPermissionWrapper {
        if (code == null) {
          //  BarcodeScannerScreen()
        } else {
            Text("Okunan barkod: $code", modifier = Modifier.padding(16.dp))
        }
    }
}