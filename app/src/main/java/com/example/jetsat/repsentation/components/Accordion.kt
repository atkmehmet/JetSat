package com.example.jetsat.repsentation.components

import androidx.collection.emptyLongSet
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Accordion(){

    var openClose by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .animateContentSize()
        ) {

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { openClose = !openClose },
                verticalAlignment = Alignment.CenterVertically
        ){
                  if (openClose)
                      Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription ="" )
                else
                   Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription ="" )
        }
        if(openClose){
            Column {
                Text(text = "Conten")
            }
        }

    }
}