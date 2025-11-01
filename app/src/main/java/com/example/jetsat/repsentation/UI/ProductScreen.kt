package com.example.jetsat.repsentation.UI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetsat.repsentation.ViewModel.ProductViewModel
import com.example.jetsat.repsentation.components.AppOutlinedTextField

@Composable
fun ProductScreen( productViewModel: ProductViewModel = hiltViewModel()){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        Text(
            text = "Add Product ",
            style = MaterialTheme.typography.headlineSmall
        )

        AppOutlinedTextField(
            value = productViewModel.product.id.toString(),
            onValueChange =null ,
            label = " Product Id",
            placeholder = " Product Id"
        )
        Spacer(Modifier.height(8.dp))

        AppOutlinedTextField(
            value = productViewModel.product.productName,
            onValueChange = productViewModel::onProductNameChange,
            label = "Product Name",
            placeholder = "Product Name"
        )

        Spacer(Modifier.height(8.dp))

        AppOutlinedTextField(
            value = productViewModel.product.productTakePrice.toString(),
            onValueChange = productViewModel::onProductTakePriceChange,
            label = "Product Take Price",
            placeholder = "Product Take Price"
        )

        Spacer(Modifier.height(8.dp))


        AppOutlinedTextField(
            value = productViewModel.product.productSoldPrice.toString(),
            onValueChange = productViewModel::onProductSoldPriceChange,
            label = "Product Sold Price",
            placeholder = "Product Sold Price"
        )



    }
}