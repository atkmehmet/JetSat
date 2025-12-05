package com.example.jetsat.repsentation.ScreenRoutes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.BookmarkAdd
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.material.icons.filled.Home


sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Customer : Screen("customer", "Customr", Icons.Default.Person)
    object Product : Screen("product", "Product", Icons.Default.BookmarkAdd)
    object InvoiceType : Screen("invoice_type", "I.Type", Icons.Default.AccountCircle)
    object Category : Screen("category", "Category", Icons.Default.Category)
    object Sales : Screen("sales", "Sales", Icons.Default.ShoppingCart)
    //object Barcode : Screen("barcode", "Barcode", Icons.Default.ThumbUp)
}
