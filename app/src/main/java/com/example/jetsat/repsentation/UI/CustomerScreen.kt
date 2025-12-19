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
import com.example.jetsat.repsentation.components.ScreenContainer

@Composable
fun CustomerScreen(
    customerViewModel: CustomerViewModel = hiltViewModel()
) {

    val customers by customerViewModel.customerList.collectAsState()
    ScreenContainer{

        // TITLE
        Text(
            text = "Add Customer",
            style = MaterialTheme.typography.headlineSmall
        )

        // ID (readonly)
        AppOutlinedTextField(
            value = customerViewModel.customer.id.toString(),
            onValueChange = null,
            label = "Customer Id",
            placeholder = "Customer Id"
        )
        Spacer(Modifier.height(12.dp))

        // NAME
        AppOutlinedTextField(
            value = customerViewModel.customer.name,
            onValueChange = customerViewModel::onNameChange,
            label = "Customer Name",
            placeholder = "Customer Name"
        )
        Spacer(Modifier.height(12.dp))

        // EMAIL
        AppOutlinedTextField(
            value = customerViewModel.customer.email ?: "",
            onValueChange = customerViewModel::onEmailChange,
            label = "Customer Email",
            placeholder = "Customer Email"
        )
        Spacer(Modifier.height(12.dp))

        // ADDRESS
        AppOutlinedTextField(
            value = customerViewModel.customer.address ?: "",
            onValueChange = customerViewModel::onAddressChange,
            label = "Customer Address",
            placeholder = "Customer Address"
        )
        Spacer(Modifier.height(12.dp))

        // PHONE
        AppOutlinedTextField(
            value = customerViewModel.customer.phone,
            onValueChange = customerViewModel::onPhoneChange,
            label = "Customer Phone",
            placeholder = "Customer Phone"
        )

        Spacer(Modifier.height(16.dp))

        // SAVE BUTTON
        Button(
            onClick = { customerViewModel.saveUpdateCustomer() },
            enabled = customerViewModel.customer.isValid(),
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }

        Spacer(Modifier.height(20.dp))

        // LIST TITLE
        Text(
            text = "Customer List",
            style = MaterialTheme.typography.headlineSmall
        )

        AccordionLib(header = "Customer List") {




        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        )
        {

            items(
                items = customers,
                key = { it.id }
            ) { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column(modifier = Modifier.weight(1f)) {
                            Text("ID: ${item.id}")
                            Text("Name: ${item.name}")
                            Text("Email: ${item.email ?: "-"}")
                            Text("Phone: ${item.phone}")
                            Text("Address: ${item.address ?: "-"}")
                        }

                        Row {

                            IconButton(onClick = { customerViewModel.onEditCustomer(item) }) {
                                Icon(Icons.Default.Edit, contentDescription = "Edit")
                            }

                            IconButton(onClick = { customerViewModel.onDeleteCustomer(item.id) }) {
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


