package com.example.jetsat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetsat.repsentation.UI.InvoiceTypeScreen
import com.example.jetsat.repsentation.UI.MainMenuScreen
import com.example.jetsat.repsentation.UI.ProductScreen
import com.example.jetsat.repsentation.UI.ProductSearchScreen
import com.example.jetsat.repsentation.UI.barcode.ScannerMainScreen
import com.example.jetsat.repsentation.components.Accordion

import com.example.jetsat.ui.theme.JetSatTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
         //   InvoiceTypeScreen()
          // ScannerMainScreen()
            //ProductSearchScreen()
           // ProductScreen()
           MainMenuScreen()
               //   Accordion()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetSatTheme {
        Greeting("Android")
    }
}