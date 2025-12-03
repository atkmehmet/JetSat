package com.example.jetsat.repsentation.ScreenRoutes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Customer : Screen("customer", "Customer", Icons.Default.Person)
    object Product : Screen("product", "Product", Icons.Default.List)
    object InvoiceType : Screen("invoice_type", "Invoice Type", Icons.Default.AccountCircle)
    object Category : Screen("category", "Category", Icons.Default.AddCircle)
    object Sales : Screen("sales", "Sales", Icons.Default.ShoppingCart)
    object Barcode : Screen("barcode", "Barcode", Icons.Default.ThumbUp)
}
