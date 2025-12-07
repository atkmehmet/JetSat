package com.example.jetsat.repsentation.UI

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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetsat.repsentation.ViewModel.CustomerViewModel
import com.example.jetsat.repsentation.components.AppOutlinedTextField
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy

@Composable
fun CustomerScreen(
    customerViewModel: CustomerViewModel = hiltViewModel()
){
    val categories by customerViewModel.customerList.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Soft gray background

    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, vertical = 12.dp)
        ) {

            Text(
                text = "Add Category ",
                style = MaterialTheme.typography.headlineSmall
            )

            AppOutlinedTextField(
                value = customerViewModel.customer.id.toString(),
                onValueChange = null,
                label = " Customer Id",
                placeholder = " Customer Id"
            )
            Spacer(Modifier.height(8.dp))


            AppOutlinedTextField(
                value = customerViewModel.customer.name,
                onValueChange = customerViewModel::onNameChange,
                label = " Customer Name",
                placeholder = " Customer Name"
            )
            Spacer(Modifier.height(8.dp))

            AppOutlinedTextField(
                value = customerViewModel.customer.email ?: "",
                onValueChange = customerViewModel::onEmailChange,
                label = " Customer Email",
                placeholder = " Customer Email"
            )

            Spacer(Modifier.height(8.dp))


            AppOutlinedTextField(
                value = customerViewModel.customer.address ?: "",
                onValueChange = customerViewModel::onAddressChange,
                label = " Customer Address",
                placeholder = " Customer Address"
            )
            Spacer(Modifier.height(8.dp))

            AppOutlinedTextField(
                value = customerViewModel.customer.phone,
                onValueChange = customerViewModel::onPhoneChange,
                label = " Customer Phone",
                placeholder = " Customer Phone"
            )

            Spacer(Modifier.height(8.dp))
            Button(
                onClick = { customerViewModel.saveUpdateCustomer() },
                enabled = customerViewModel.customer.isValid(),
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Save")
            }

            Spacer(Modifier.height(8.dp))

            Text(
                text = "Customer List",
                style = MaterialTheme.typography.titleMedium
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
            {
                items(items = categories,
                    key = { it.id }
                ) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {


                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = "Name: ${item.id}")
                                Text(text = "Name: ${item.name}")
                                Text(text = "Name: ${item.email}")
                                Text(text = "Name: ${item.phone}")
                            }



                            Row {

                                // DÜZENLE BUTONU
                                IconButton(onClick = { customerViewModel.onEditCustomer(item) }) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "Edit"
                                    )
                                }

                                // SİL BUTONU
                                IconButton(onClick = { customerViewModel.onDeleteCustomer(item.id) }) {
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = "Delete"
                                    )
                                }
                            }
                        }


                    }
                }

            }
        }

    }
}