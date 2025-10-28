package com.example.jetsat.repsentation.UI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Add Category ",
            style = MaterialTheme.typography.headlineSmall
        )

        AppOutlinedTextField(
            value = customerViewModel.customer.id.toString(),
            onValueChange =null ,
            label = " code",
            placeholder = " code"
        )
    }

}