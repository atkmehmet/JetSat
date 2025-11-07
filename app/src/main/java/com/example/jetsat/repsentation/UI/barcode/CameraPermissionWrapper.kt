package com.example.jetsat.repsentation.UI.barcode



import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.*

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraPermissionWrapper(onGranted: @Composable () -> Unit) {
    val permissionState = rememberPermissionState(android.Manifest.permission.CAMERA)

    when {
        permissionState.status.isGranted -> onGranted()
        permissionState.status.shouldShowRationale -> {
            PermissionRationale { permissionState.launchPermissionRequest() }
        }
        else -> {
            PermissionRequestView { permissionState.launchPermissionRequest() }
        }
    }
}

@Composable
fun PermissionRationale(onRequest: () -> Unit) {
    Column(Modifier.padding(16.dp)) {
        Text("Kamera izni gerekli.")
        Spacer(Modifier.height(8.dp))
        Button(onClick = onRequest) { Text("İzin ver") }
    }
}

@Composable
fun PermissionRequestView(onRequest: () -> Unit) {
    Column(Modifier.padding(16.dp)) {
        Text("Lütfen kamera izni verin.")
        Spacer(Modifier.height(8.dp))
        Button(onClick = onRequest) { Text("İzin iste") }
    }
}
