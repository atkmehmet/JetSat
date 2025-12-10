package com.example.jetsat.repsentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun Accordion(){

    var openClose by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.fillMaxSize()
        .padding(16.dp),
        ) {

    }
}