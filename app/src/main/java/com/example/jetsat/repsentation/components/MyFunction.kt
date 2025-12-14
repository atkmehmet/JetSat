package com.example.jetsat.repsentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableFloatState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyFunction(){
    var openClose by remember {
        mutableStateOf(false)
    }

    val rotation by animateFloatAsState(
        targetValue = if(openClose) 180f else 0f,
        label = "")


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
            .animateContentSize(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)

    ) {
        Column(modifier = Modifier.background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF2196F3), // Mavi
                    Color(0xFF21CBF3)  // Açık mavi
                )
            )
        )) {
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .clickable { openClose = !openClose }
                    .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                   
                    Text(text = "See Products"
                    , modifier = Modifier.weight(1f)
                    , fontSize = 16.sp
                    , fontWeight = FontWeight.Medium)
    
                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription =""
                        , modifier = Modifier.rotate(rotation))
                }
            AnimatedVisibility(visible = openClose,
                enter = fadeIn()+ expandVertically () ,
                exit = fadeOut() + shrinkVertically ()
            ) {
                Text(text = "Hello World")
            }

           }
    }
}