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
import com.example.jetsat.repsentation.ViewModel.CategoryViewModel
import com.example.jetsat.repsentation.components.AppOutlinedTextField

@Composable
fun CategoryScreen( categoryViewModel: CategoryViewModel = hiltViewModel()){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            text = "Add Invoice Type",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.height(16.dp))

        AppOutlinedTextField(
            value = categoryViewModel.category.categoryName,
            onValueChange = categoryViewModel::onNameChange,
            label = "Code",
            placeholder = "Enter code"
        )

    }

}