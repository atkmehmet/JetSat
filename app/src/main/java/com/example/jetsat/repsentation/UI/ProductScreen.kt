package com.example.jetsat.repsentation.UI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetsat.repsentation.ViewModel.ProductViewModel
import com.example.jetsat.repsentation.components.AppOutlinedTextField
import com.example.jetsat.repsentation.components.CustomOutlinedTextField
import com.example.jetsat.repsentation.components.SearchableDropdownTextField

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


        CustomOutlinedTextField(
            value = productViewModel.product.productTakePrice.toString(),
            onValueChange =  productViewModel::onProductTakePriceChange,
            label = "Product Take Price",
            keyboardType = KeyboardType.Decimal,
            prefix = "₺",
            suffix = "TL"
        )


        Spacer(Modifier.height(8.dp))


        CustomOutlinedTextField(
            value = productViewModel.product.productSoldPrice.toString(),
            onValueChange = productViewModel::onProductSoldPriceChange,
            label = "Product Sold Price",
            keyboardType = KeyboardType.Decimal,
            prefix = "₺",
            suffix = "TL"
        )

        Spacer(Modifier.height(8.dp))

        SearchableDropdownTextField(
            items = productViewModel.categoryList.collectAsState().value,
            itemToString = {it.categoryName},
            selectedItem = productViewModel.category,
            onItemSelected = {category ->
                productViewModel.category = category
            }
            ,
            label = "Choose Category",
            placeholder = "Choose Category"
        )

    }
}