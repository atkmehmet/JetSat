package com.example.jetsat.repsentation.UI

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetsat.repsentation.ViewModel.ProductViewModel
import com.example.jetsat.repsentation.components.AppOutlinedTextField
import com.example.jetsat.repsentation.components.CustomOutlinedTextField
import com.example.jetsat.repsentation.components.SearchableDropdownTextField
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.jetsat.repsentation.components.ScreenContainer

@Composable
fun ProductScreen(productViewModel: ProductViewModel = hiltViewModel()) {

    val productList by productViewModel.productList.collectAsState()
    val categoryList by productViewModel.categoryList.collectAsState()

    var openClose by remember {
        mutableStateOf(false)
    }
    val rotation by  animateFloatAsState(
        targetValue = if (openClose) 180f else 0f,
        label = ""
    )

    ScreenContainer {

            Text(
                text = "Add Product",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    AppOutlinedTextField(
                        value = productViewModel.product.id.toString(),
                        onValueChange = null,
                        label = "Product Id",
                        placeholder = "Product Id"
                    )

                    Spacer(Modifier.height(12.dp))

                    AppOutlinedTextField(
                        value = productViewModel.product.productName,
                        onValueChange = productViewModel::onProductNameChange,
                        label = "Product Name",
                        placeholder = "Product Name"
                    )

                    Spacer(Modifier.height(12.dp))

                    CustomOutlinedTextField(
                        value = productViewModel.product.productTakePrice.toString(),
                        onValueChange = productViewModel::onProductTakePriceChange,
                        label = "Product Take Price",
                        keyboardType = KeyboardType.Decimal,
                        prefix = "₺",
                        suffix = "TL"
                    )

                    Spacer(Modifier.height(12.dp))

                    CustomOutlinedTextField(
                        value = productViewModel.product.productSoldPrice.toString(),
                        onValueChange = productViewModel::onProductSoldPriceChange,
                        label = "Product Sold Price",
                        keyboardType = KeyboardType.Decimal,
                        prefix = "₺",
                        suffix = "TL"
                    )

                    Spacer(Modifier.height(12.dp))

                    SearchableDropdownTextField(
                        items = categoryList,
                        itemToString = { it.categoryName },
                        selectedItem = productViewModel.category,
                        onItemSelected = { category -> productViewModel.category = category },
                        label = "Choose Category",
                        placeholder = "Choose Category"
                    )
                }
            }

            Spacer(Modifier.height(20.dp))

            Text(
                text = "Product List",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

           AccordionLib(header = "Product List") {


               LazyColumn(
                   modifier = Modifier.fillMaxSize()
               ) {
                   items(productList, key = { it.id }) { item ->
                       Card(
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(vertical = 6.dp),
                           shape = RoundedCornerShape(16.dp),
                           elevation = CardDefaults.cardElevation(4.dp)
                       ) {
                           Row(
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .padding(16.dp),
                               horizontalArrangement = Arrangement.SpaceBetween
                           ) {

                               Column(modifier = Modifier.weight(1f)) {
                                   Text(text = "Name: ${item.productName}")
                                   Text(text = "Buy: ${item.productTakePrice} TL")
                                   Text(text = "Sell: ${item.productSoldPrice} TL")
                               }

                               Row {
                                   IconButton(onClick = { productViewModel.onEditProduct(item) }) {
                                       Icon(Icons.Default.Edit, contentDescription = "Edit")
                                   }
                                   IconButton(onClick = { productViewModel.onDeleteProduct(item.id) }) {
                                       Icon(Icons.Default.Delete, contentDescription = "Delete")
                                   }
                               }
                           }
                       }
                   }
               }
           }
        }
    }

