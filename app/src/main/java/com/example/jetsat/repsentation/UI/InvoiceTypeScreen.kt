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
import com.example.jetsat.domain.model.InvoiceType
import com.example.jetsat.repsentation.ViewModel.InvoiceTypeViewModel
import com.example.jetsat.repsentation.components.AppOutlinedTextField

@Composable
fun InvoiceTypeScreen(
    viewModel: InvoiceTypeViewModel = hiltViewModel(),
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Add Invoice Type",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.height(16.dp))

        AppOutlinedTextField(
            value = viewModel.invoiceType.code,
                onValueChange = viewModel::onCodeChange,
            label = "Code",
            placeholder = "Enter code"
        )

        Spacer(Modifier.height(8.dp))

        AppOutlinedTextField(
            value = viewModel.invoiceType.name,
            onValueChange = viewModel::onNameChange,
            label = "Name",
            placeholder = "Enter name"
        )

        Spacer(Modifier.height(8.dp))

        AppOutlinedTextField(
            value = viewModel.invoiceType.description?:"veri girişi",
            onValueChange = viewModel::onDescriptionChange,
            label = "Description",
            placeholder = "Optional",
            singleLine = false
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { viewModel.saveUpdate() },
            enabled = viewModel.invoiceType.isValid(),
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }
    }
}
