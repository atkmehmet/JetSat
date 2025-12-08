package com.example.jetsat.repsentation.UI

import android.graphics.drawable.Icon
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetsat.domain.model.InvoiceType
import com.example.jetsat.repsentation.ViewModel.InvoiceTypeViewModel
import com.example.jetsat.repsentation.components.AppOutlinedTextField
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import com.example.jetsat.repsentation.components.ScreenContainer

@Composable
fun InvoiceTypeScreen(
    viewModel: InvoiceTypeViewModel = hiltViewModel(),
) {

    val invoiceType by viewModel.invoiceTypeList.collectAsState()
    ScreenContainer {
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
                value = viewModel.invoiceType.description ?: "veri girişi",
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

            Spacer(Modifier.height(8.dp))

            Text(
                text = "Invoice Type List",
                style = MaterialTheme.typography.titleMedium
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            {
                items(items = invoiceType,
                    key = { it.id }) { item ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column(modifier = Modifier.weight(1f)) {

                                Text(text = "Name: ${item.id}")
                                Text(text = "Name: ${item.name}")
                                Text(text = "Name: ${item.code}")
                                Text(text = "Name: ${item.description}")
                            }

                            Row {

                                // DÜZENLE BUTONU
                                IconButton(onClick = { viewModel.onEditInvoiceType(item) }) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "Edit"
                                    )
                                }

                                // SİL BUTONU
                                IconButton(onClick = { viewModel.onDeleteInvoiceType(item.id) }) {
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

