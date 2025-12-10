package com.example.jetsat.repsentation.UI

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetsat.repsentation.ScreenRoutes.Screen
import androidx.navigation.compose.rememberNavController

@Composable
fun MainMenuScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            AppBottomBar(navController)
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Customer.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Screen.Customer.route) { CustomerScreen() }
            composable(Screen.Product.route) { ProductScreen() }
            composable(Screen.InvoiceType.route) { InvoiceTypeScreen() }
            composable(Screen.Category.route) { CategoryScreen() }
            //composable(Screen.Sales.route) { ProductSearchScreen() }
           // composable(Screen.Barcode.route) { ProductSearchScreen() }
        }
    }
}
