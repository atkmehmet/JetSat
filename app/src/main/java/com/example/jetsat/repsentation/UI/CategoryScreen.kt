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
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetsat.repsentation.ViewModel.CategoryViewModel
import com.example.jetsat.repsentation.components.AppOutlinedTextField
import com.example.jetsat.repsentation.components.ScreenContainer
import com.example.jetsat.repsentation.components.StylishCard

@Composable
fun CategoryScreen(categoryViewModel: CategoryViewModel = hiltViewModel()) {

    val categories by categoryViewModel.categories.collectAsState()

    ScreenContainer {

        // Başlık
        Text(
            text = "Add Category",
            style = MaterialTheme.typography.headlineSmall
        )

        // Category ID
        AppOutlinedTextField(
            value = categoryViewModel.category.id.toString(),
            onValueChange = null,
            label = "Code",
            placeholder = "Code"
        )

        Spacer(Modifier.height(16.dp))

        // Category Name
        AppOutlinedTextField(
            value = categoryViewModel.category.categoryName,
            onValueChange = categoryViewModel::onNameChange,
            label = "Name",
            placeholder = "Enter Name"
        )

        Spacer(Modifier.height(16.dp))

        // Kaydet butonu
        Button(
            onClick = { categoryViewModel.saveUpdate() },
            enabled = categoryViewModel.category.categoryName.isNotEmpty(),
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }

        Spacer(Modifier.height(12.dp))

        // Liste başlık
        Text(
            text = "Category List",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(Modifier.height(8.dp))

        // Liste
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {

            items(categories) { item ->

                StylishCard {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Id: ${item.id}")
                        Text("Name: ${item.categoryName}")
                    }

                    Row {
                        IconButton(onClick = { categoryViewModel.onEditCategory(item) }) {
                            Icon(Icons.Default.Edit, contentDescription = "Edit")
                        }

                        IconButton(onClick = { categoryViewModel.onDeleteCategory(item.id) }) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete")
                        }
                    }
                }
            }
        }
    }
}
