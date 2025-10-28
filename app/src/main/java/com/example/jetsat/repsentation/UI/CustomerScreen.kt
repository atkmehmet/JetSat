package com.example.jetsat.repsentation.UI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetsat.repsentation.ViewModel.CustomerViewModel
import com.example.jetsat.repsentation.components.AppOutlinedTextField


@Composable
fun CustomerScreen(
    customerViewModel: CustomerViewModel = hiltViewModel()
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Add Category ",
            style = MaterialTheme.typography.headlineSmall
        )

        AppOutlinedTextField(
            value = customerViewModel.customer.id.toString(),
            onValueChange =null ,
            label = " Customer Id",
            placeholder = " Customer Id"
        )
        Spacer(Modifier.height(8.dp))


        AppOutlinedTextField(
            value = customerViewModel.customer.name,
            onValueChange = customerViewModel::onNameChange ,
            label = " Customer Name",
            placeholder = " Customer Name"
        )
        Spacer(Modifier.height(8.dp))

        AppOutlinedTextField(
            value = customerViewModel.customer.email?:"",
            onValueChange = customerViewModel::onEmailChange ,
            label = " Customer Email",
            placeholder = " Customer Email"
        )

        Spacer(Modifier.height(8.dp))


        AppOutlinedTextField(
            value = customerViewModel.customer.address?:"",
            onValueChange = customerViewModel::onAddressChange ,
            label = " Customer Address",
            placeholder = " Customer Address"
        )
        Spacer(Modifier.height(8.dp))

        AppOutlinedTextField(
            value = customerViewModel.customer.phone,
            onValueChange = customerViewModel::onPhoneChange ,
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
    }

}